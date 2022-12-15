package com.example.convenios.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="tutor_emp")

class TutorEmp {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank
    var funcion:String?=null
    @Column(name="empresa_id")
    var empresaId:String?=null
}