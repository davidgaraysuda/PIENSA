package com.example.convenios.controller

import com.example.convenios.model.Tareas
import com.example.convenios.service.TareasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/careras")

class TareasController {
    @Autowired
    lateinit var tareasService: TareasService

    @PostMapping
    fun save (@RequestBody @Valid tareas:Tareas): Tareas {
        return tareasService.save(tareas)
    }

    @GetMapping
    fun list ():List<Tareas>{
        return tareasService.list()
    }

    @GetMapping("/{id}")
    fun listId(@PathVariable("id") id:Long):ResponseEntity<Tareas>{
        return ResponseEntity(tareasService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid tareas:Tareas):ResponseEntity<Tareas>{
        return ResponseEntity(tareasService.update(tareas), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid tareas:Tareas): ResponseEntity<Tareas>{
        return ResponseEntity(tareasService.updateName(tareas), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return tareasService.delete(id)
    }
}