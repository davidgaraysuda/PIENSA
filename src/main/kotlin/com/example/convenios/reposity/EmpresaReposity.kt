package com.example.convenios.reposity

import com.example.convenios.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository

interface EmpresaReposity: JpaRepository<Empresa, Long?> {
    fun findById(id:Long?): Empresa
}