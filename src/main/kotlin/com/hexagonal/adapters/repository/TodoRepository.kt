package com.hexagonal.adapters.repository

import com.hexagonal.adapters.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {

}