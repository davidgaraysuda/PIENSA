package com.example.convenios.controller

import com.example.convenios.model.Convenio
import com.example.convenios.service.ConvenioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/careras")

class ConvenioController {
    @Autowired
    lateinit var convenioService: ConvenioService

    @PostMapping
    fun save (@RequestBody @Valid convenio:Convenio): Convenio {
        return convenioService.save(convenio)
    }

    @GetMapping
    fun list ():List<Convenio>{
        return convenioService.list()
    }

    @GetMapping("/{id}")
    fun listId(@PathVariable("id") id:Long):ResponseEntity<Convenio>{
        return ResponseEntity(convenioService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid convenio:Convenio):ResponseEntity<Convenio>{
        return ResponseEntity(convenioService.update(convenio), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid convenio:Convenio): ResponseEntity<Convenio>{
        return ResponseEntity(convenioService.updateName(convenio), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return convenioService.delete(id)
    }
}