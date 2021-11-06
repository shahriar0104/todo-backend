package com.dsi.todo.controller;

import com.dsi.todo.exception.ResourceNotFoundException;
import com.dsi.todo.model.Todo;
import com.dsi.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    public Todo postTodos(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping("todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return todoService.getTodoById(id);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable (value = "id") Long id, @RequestBody Todo todo)
        throws ResourceNotFoundException {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    private ResponseEntity<?> deleteEmployee(@PathVariable (value = "id") Long id)
            throws ResourceNotFoundException {
        return todoService.deleteTodo(id);
    }
}
