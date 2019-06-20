package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
