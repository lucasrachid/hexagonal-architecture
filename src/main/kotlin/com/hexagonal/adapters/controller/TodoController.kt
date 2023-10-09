package com.hexagonal.adapters.controller

import com.hexagonal.adapters.dto.TodoDTO
import com.hexagonal.ports.TodoPort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/todo")
class TodoController(private val todoPort: TodoPort) {

    @GetMapping
    fun getListTodo(): List<TodoDTO?>? {
        return todoPort.getListTodo()
    }

    @PostMapping
    fun create(@RequestBody todo: TodoDTO): TodoDTO? {
        return todoPort.create(todo)
    }

    @PutMapping
    fun update(@RequestBody todo: TodoDTO): TodoDTO? {
        return todoPort.update(todo)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<String> {
        todoPort.delete(id)
        return ResponseEntity.ok("Excluido com sucesso")
    }
}