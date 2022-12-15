package com.example.convenios.reposity

import com.example.convenios.model.Carreras
import org.springframework.data.jpa.repository.JpaRepository

interface CarrerasReposity: JpaRepository<Carreras, Long?> {
    fun findById(id:Long?):Carreras
}