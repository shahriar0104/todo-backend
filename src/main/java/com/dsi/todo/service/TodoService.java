package com.dsi.todo.service;

import com.dsi.todo.exception.ResourceNotFoundException;
import com.dsi.todo.model.Todo;
import com.dsi.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> todoList = todoRepository.findAll();
        return ResponseEntity.ok().body(todoList);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public ResponseEntity<Todo> getTodoById(Long id) throws ResourceNotFoundException {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo Not Found"));
        return ResponseEntity.ok().body(todo);
    }

    public ResponseEntity<Todo> updateTodo(Long id, Todo requestTodo) throws ResourceNotFoundException {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo Not Found"));
        todo.setName(requestTodo.getName());
        todo.setEmail(requestTodo.getEmail());
        todo.setTodo(requestTodo.getTodo());
        todoRepository.save(todo);
        return ResponseEntity.ok().body(todo);
    }

    public ResponseEntity<?> deleteTodo(Long id) throws ResourceNotFoundException {
        todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo Not Found"));
        todoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
