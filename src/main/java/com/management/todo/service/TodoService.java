package com.management.todo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.todo.model.Todo;
import com.management.todo.repository.ToDoRepository;

@Service
public class TodoService implements ITodoService{
    

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<Todo> getTodosByUser(String user) {

        return toDoRepository.findByUserName(user);

    } 

    @Override
    public Optional<Todo> getTodoById(long id) {

        return toDoRepository.findById(id);

    }

    @Override
    public void updateTodo(Todo todo) {

        toDoRepository.save(todo);

    }

    @Override
    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {

        toDoRepository.save(new Todo(name, desc, targetDate, isDone));

    }

    @Override
    public void deleteTodo(long id) {

        Optional<Todo> todo = toDoRepository.findById(id);

        if(todo.isPresent()) {

            toDoRepository.delete(todo.get());

        }

    }

    @Override
    public void saveTodo(Todo todo) {

        toDoRepository.save(todo);

    }
    
}
