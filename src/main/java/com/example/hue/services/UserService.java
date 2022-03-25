package com.example.hue.services;

import com.example.hue.common.exception.UserAlreadyExistAuthenticationException;
import com.example.hue.common.request.SignupRequest;
import com.example.hue.models.dto.LocalUser;
import com.example.hue.models.entity.User;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    User registerNewUser(SignupRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

    User findUserByEmail(String email);
    Optional<User> findUserById(Long id);
    LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);

}
