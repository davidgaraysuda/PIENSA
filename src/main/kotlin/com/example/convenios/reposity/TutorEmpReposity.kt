package com.example.convenios.reposity

import com.example.convenios.model.TutorEmp
import org.springframework.data.jpa.repository.JpaRepository

interface TutorEmpReposity: JpaRepository<TutorEmp, Long?> {
    fun findById(id:Long?): TutorEmp
}