package com.webserverproject.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webserverproject.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
