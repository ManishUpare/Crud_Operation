package com.bikkadIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadIt.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
