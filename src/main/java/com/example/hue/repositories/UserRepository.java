package com.example.hue.repositories;

import com.example.hue.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    User findUserByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByPhone(String phone);
    Boolean existsByEmail(String email);

    User findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "update users set password =?1 where username=?2 ",nativeQuery = true)
    void saveNewPassword(String password, String username);

    @Transactional
    @Modifying
    @Query(value ="update users set verification_code =?1 where username =?2",nativeQuery = true)
    void addVerificationCode(String code, String username);

    @Transactional
    @Query(value = "select * from users where verification_code =?1 and active=true",nativeQuery = true)
    User findUserByVerificationCode(String verifyCode);

//    User findUserByVerificationCodeAndActive(String code);
}
