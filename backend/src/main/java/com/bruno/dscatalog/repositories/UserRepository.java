package com.bruno.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.dscatalog.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
