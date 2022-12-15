package com.example.convenios.model
import javax.persistence.*

@Entity
@Table(name="direccion")

class Direccion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var dir: String?=null
    @Column(name="empresa_id")
    var empresaId:Long?=null
}