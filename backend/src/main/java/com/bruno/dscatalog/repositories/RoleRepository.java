package com.bruno.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.dscatalog.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
