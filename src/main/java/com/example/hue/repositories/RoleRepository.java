package com.example.hue.repositories;

import com.example.hue.common.enums.ERole;
import com.example.hue.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    Role findByName(String name);
}
