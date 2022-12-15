package com.example.convenios.reposity


import com.example.convenios.model.Direccion
import org.springframework.data.jpa.repository.JpaRepository

interface DireccionReposity: JpaRepository<Direccion, Long?> {
    fun findById(id:Long?): Direccion
}