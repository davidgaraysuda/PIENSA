package com.example.convenios.reposity

import com.example.convenios.model.Tareas
import org.springframework.data.jpa.repository.JpaRepository

interface TareasReposity: JpaRepository<Tareas, Long?> {
    fun findById(id:Long?): Tareas
}