package com.weatherservice.repository;

import com.weatherservice.entity.Role;
import com.weatherservice.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(UserType roleName);
}
