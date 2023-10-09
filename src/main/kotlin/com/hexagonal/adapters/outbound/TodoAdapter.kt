package com.hexagonal.adapters.outbound

import com.fasterxml.jackson.databind.ObjectMapper
import com.hexagonal.adapters.dto.TodoDTO
import com.hexagonal.adapters.model.Todo
import com.hexagonal.adapters.repository.TodoRepository
import com.hexagonal.ports.TodoPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
@Transactional
class TodoAdapter(private val todoRepository: TodoRepository, private val objectMapper: ObjectMapper) : TodoPort {

    override fun create(todoDTO: TodoDTO?): TodoDTO? {
        val newTodo = Todo(
            id = null,
            item = todoDTO?.item ?: ""
        )
        todoRepository.save(newTodo)
        return objectMapper.convertValue(newTodo, TodoDTO::class.java)
    }

    override fun update(todoDTO: TodoDTO?): TodoDTO? {
        val todoToUpdate = todoDTO?.let { it.id?.let { it1 -> todoRepository.findById(it1).orElse(null) } }
        if (todoToUpdate != null) {
            todoToUpdate.item = todoDTO.item
            todoRepository.save(todoToUpdate)
            return objectMapper.convertValue(todoToUpdate, TodoDTO::class.java)
        }
        return null
    }

    override fun delete(id: Long?) {
        todoRepository.deleteById(id!!)
    }

    override fun getListTodo(): List<TodoDTO> {
        return todoRepository.findAll().stream()
            .map { todo -> objectMapper.convertValue(todo, TodoDTO::class.java) }
            .collect(Collectors.toList())
    }
}