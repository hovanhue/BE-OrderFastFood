package com.example.hue.services.impl;

import com.example.hue.common.enums.SocialProvider;
import com.example.hue.common.exception.OAuth2AuthenticationProcessingException;
import com.example.hue.common.exception.UserAlreadyExistAuthenticationException;
import com.example.hue.common.request.SignupRequest;
import com.example.hue.common.utils.GeneralUtils;
import com.example.hue.models.dto.LocalUser;
import com.example.hue.models.entity.Role;
import com.example.hue.models.entity.User;
import com.example.hue.repositories.RoleRepository;
import com.example.hue.repositories.UserRepository;
import com.example.hue.sercurity.OAuth2.user.OAuth2UserInfo;
import com.example.hue.sercurity.OAuth2.user.OAuth2UserInfoFactory;
import com.example.hue.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(value = "transactionManager")
    public User registerNewUser(final SignupRequest signUpRequest) throws UserAlreadyExistAuthenticationException {
        if (signUpRequest.getUsername() != null && userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new UserAlreadyExistAuthenticationException("User with User name " + signUpRequest.getUsername() + " already exist");
        } else if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new UserAlreadyExistAuthenticationException("User with email id " + signUpRequest.getEmail() + " already exist");
        }
        User user = buildUser(signUpRequest);
//		Date now = Calendar.getInstance().getTime();
//		user.setCreatedDate(now);
//		user.setModifiedDate(now);
        user = userRepository.save(user);
        System.out.println("register");
        userRepository.flush();
        return user;
    }

    private User buildUser(final SignupRequest formDTO) {
        User user = new User();
        user.setEmail(formDTO.getEmail());
        user.setUsername(formDTO.getUsername());
        user.setPassword(passwordEncoder.encode(formDTO.getPassword()));

        final HashSet<Role> roles = new HashSet<Role>();
        roles.add(roleRepository.findByName(Role.ROLE_USER));
        user.setRoles(roles);
        user.setActive(true);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, attributes);
        if (StringUtils.isEmpty(oAuth2UserInfo.getName())) {
            throw new OAuth2AuthenticationProcessingException("Name not found from OAuth2 provider");
        } else if (StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }
        SignupRequest userDetails = toUserRegistrationObject(registrationId, oAuth2UserInfo);
        User user = findUserByEmail(oAuth2UserInfo.getEmail());
        if (user != null) {
            if (!user.getProvider().equals(registrationId) && !user.getProvider().equals(SocialProvider.LOCAL.getProviderType())) {
                throw new OAuth2AuthenticationProcessingException(
                        "Looks like you're signed up with " + user.getProvider() + " account. Please use your " + user.getProvider() + " account to login.");
            }
            user = updateExistingUser(user, oAuth2UserInfo);
        } else {
            user = registerNewUser(userDetails);
        }
        System.out.println(user.getEmail());
        return LocalUser.create(user, attributes, idToken, userInfo);
    }

    private SignupRequest toUserRegistrationObject(String registrationId, OAuth2UserInfo oAuth2UserInfo) {
        return SignupRequest.getBuilder().addEmail(oAuth2UserInfo.getEmail())
                .addSocialProvider(GeneralUtils.toSocialProvider(registrationId)).addPassword("changeit").build();
    }

    private User updateExistingUser(User existingUser, OAuth2UserInfo oAuth2UserInfo) {
        existingUser.setName(oAuth2UserInfo.getName());
        return userRepository.save(existingUser);
    }
}
