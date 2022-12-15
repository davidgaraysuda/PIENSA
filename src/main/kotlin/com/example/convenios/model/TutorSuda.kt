package com.example.convenios.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="tutor_suda")

class TutorSuda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank
    var rol:String?=null
    @Column(name="carreras_id")
    var carrerasId:String?=null
}