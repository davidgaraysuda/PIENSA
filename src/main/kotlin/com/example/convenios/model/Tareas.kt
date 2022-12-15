package com.example.convenios.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="tareas")

class Tareas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank
    var detalles:String?=null
    @Column(name="convenio_id")
    var convenioId:String?=null
}