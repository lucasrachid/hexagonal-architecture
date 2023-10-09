package com.hexagonal.adapters.model

import jakarta.persistence.*

@Entity
@Table(name = "todo")
data class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    var item: String?,

    val isCompleted: Boolean? = null
)