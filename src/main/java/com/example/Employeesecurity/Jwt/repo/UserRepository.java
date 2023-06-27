package com.example.Employeesecurity.Jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employeesecurity.Jwt.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUsername(String username);

}