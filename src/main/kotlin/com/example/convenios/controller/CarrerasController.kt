package com.example.convenios.controller

import com.example.convenios.model.Carreras
import com.example.convenios.service.CarrerasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/careras")

class CarrerasController {
    @Autowired
    lateinit var carrerasService: CarrerasService

    @PostMapping
    fun save (@RequestBody @Valid carreras:Carreras): Carreras {
        return carrerasService.save(carreras)
    }

    @GetMapping
    fun list ():List<Carreras>{
        return carrerasService.list()
    }

    @GetMapping("/{id}")
    fun listId(@PathVariable("id") id:Long):ResponseEntity<Carreras>{
        return ResponseEntity(carrerasService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid carreras:Carreras):ResponseEntity<Carreras>{
        return ResponseEntity(carrerasService.update(carreras), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid carreras:Carreras): ResponseEntity<Carreras>{
        return ResponseEntity(carrerasService.updateName(carreras), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return carrerasService.delete(id)
    }
}