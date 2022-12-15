package com.example.convenios.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="carreras")

class Carreras {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank
    var especialidad: String? = null
    var descripcion: String?=null
    @Column(name="state_car")
    @NotBlank
    var stateCar: String?=null
    @Column(name="convenio_id")
    var convenioId:Long?=null
}