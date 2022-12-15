package com.example.convenios.controller

import com.example.convenios.model.Direccion
import com.example.convenios.service.DireccionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/careras")

class DireccionController {
    @Autowired
    lateinit var direccionService: DireccionService

    @PostMapping
    fun save (@RequestBody @Valid direccion:Direccion): Direccion {
        return direccionService.save(direccion)
    }

    @GetMapping
    fun list ():List<Direccion>{
        return direccionService.list()
    }

    @GetMapping("/{id}")
    fun listId(@PathVariable("id") id:Long):ResponseEntity<Direccion>{
        return ResponseEntity(direccionService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid direccion:Direccion):ResponseEntity<Direccion>{
        return ResponseEntity(direccionService.update(direccion), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid direccion:Direccion): ResponseEntity<Direccion>{
        return ResponseEntity(direccionService.updateName(direccion), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return direccionService.delete(id)
    }
}