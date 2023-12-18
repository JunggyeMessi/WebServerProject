package com.webserverproject.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webserverproject.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}