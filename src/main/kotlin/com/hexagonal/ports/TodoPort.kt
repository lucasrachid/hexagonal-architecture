package com.hexagonal.ports

import com.hexagonal.adapters.dto.TodoDTO

interface TodoPort {

    fun create(todoDTO: TodoDTO?): TodoDTO?

    fun update(todoDTO: TodoDTO?): TodoDTO?

    fun delete(id: Long?)

    fun getListTodo(): List<TodoDTO?>?

}