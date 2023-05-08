package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
@RequestMapping("/todos")
public class SpringBootForUniApplication {

	private List<Todo> todos = new ArrayList<>();

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todos.add(todo);
        return todo;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todos;
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable long id) {
        Optional<Todo> optionalTodo = todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst();
        return optionalTodo.orElse(null);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable long id, @RequestBody Todo updatedTodo) {
        Optional<Todo> optionalTodo = todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst();
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setTodo(updatedTodo.getTodo());
            todo.setPriority(updatedTodo.getPriority());
            return todo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteTodo(@PathVariable long id) {
        return todos.removeIf(todo -> todo.getId() == id);
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoController.class, args);
    }

}