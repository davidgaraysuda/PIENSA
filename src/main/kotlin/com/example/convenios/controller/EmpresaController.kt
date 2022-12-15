package com.example.convenios.controller

import com.example.convenios.model.Empresa
import com.example.convenios.service.EmpresaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/careras")

class EmpresaController {
    @Autowired
    lateinit var empresaService: EmpresaService

    @PostMapping
    fun save (@RequestBody @Valid empresa:Empresa): Empresa {
        return empresaService.save(empresa)
    }

    @GetMapping
    fun list ():List<Empresa>{
        return empresaService.list()
    }

    @GetMapping("/{id}")
    fun listId(@PathVariable("id") id:Long):ResponseEntity<Empresa>{
        return ResponseEntity(empresaService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid empresa:Empresa):ResponseEntity<Empresa>{
        return ResponseEntity(empresaService.update(empresa), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid empresa:Empresa): ResponseEntity<Empresa>{
        return ResponseEntity(empresaService.updateName(empresa), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return empresaService.delete(id)
    }
}