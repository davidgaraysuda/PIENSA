package com.example.convenios.reposity

import com.example.convenios.model.TutorSuda
import org.springframework.data.jpa.repository.JpaRepository

interface TutorSudaReposity: JpaRepository<TutorSuda, Long?> {
    fun findById(id:Long?): TutorSuda
}