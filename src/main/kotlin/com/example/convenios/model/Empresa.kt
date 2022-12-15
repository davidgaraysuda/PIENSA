package com.example.convenios.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="empresa")

class Empresa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="name_emp")
    @NotBlank
    var nameEmp:String?=null
    @Column(name="state_emp")
    var stateEmp:String?=null
}