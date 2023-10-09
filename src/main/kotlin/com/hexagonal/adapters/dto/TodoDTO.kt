package com.hexagonal.adapters.dto

data class TodoDTO(
    var id: Long? = null,
    var item: String,
    var isCompleted: Boolean? = null
)