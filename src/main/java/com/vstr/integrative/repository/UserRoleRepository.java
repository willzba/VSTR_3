package com.vstr.integrative.repository;

import com.vstr.integrative.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, Long> {

        Role findRoleByUsers_Id(String userId);

        Role findByName(String name);
}
