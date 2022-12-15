package com.example.convenios.model

import java.util.Date
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="convenio")

class Convenio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="fecha_inicio")
    @NotNull
    var fechaInicio: Date? = null
    @Column(name="fecha_fin")
    @NotNull
    var fechaFin: Date?=null
    @Column(name="state_con")
    @NotBlank
    var stateCon: String?=null
    @Column(name="empresa_id")
    var empresaId:Long?=null
}