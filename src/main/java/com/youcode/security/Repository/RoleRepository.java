package com.youcode.security.Repository;

import com.youcode.security.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByRoleName(String role);
}
