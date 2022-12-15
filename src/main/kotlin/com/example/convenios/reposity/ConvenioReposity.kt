package com.example.convenios.reposity


import com.example.convenios.model.Convenio
import org.springframework.data.jpa.repository.JpaRepository

interface ConvenioReposity: JpaRepository<Convenio, Long?> {
    fun findById(id:Long?): Convenio
}