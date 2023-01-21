package com.management.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.todo.model.Todo;

public interface ToDoRepository extends JpaRepository <Todo, Long>{
    
    List <Todo> findByUserName(String user);
    
}
