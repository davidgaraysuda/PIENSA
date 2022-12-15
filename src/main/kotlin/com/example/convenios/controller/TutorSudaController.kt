package com.example.convenios.controller

import com.example.convenios.model.TutorSuda
import com.example.convenios.service.TutorSudaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/careras")

class TutorSudaController {
    @Autowired
    lateinit var tutorSudaService: TutorSudaService

    @PostMapping
    fun save (@RequestBody @Valid tutorSuda:TutorSuda): TutorSuda {
        return tutorSudaService.save(tutorSuda)
    }

    @GetMapping
    fun list ():List<TutorSuda>{
        return tutorSudaService.list()
    }

    @GetMapping("/{id}")
    fun listId(@PathVariable("id") id:Long):ResponseEntity<TutorSuda>{
        return ResponseEntity(tutorSudaService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid tutorSuda:TutorSuda):ResponseEntity<TutorSuda>{
        return ResponseEntity(tutorSudaService.update(tutorSuda), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid tutorSuda:TutorSuda): ResponseEntity<TutorSuda>{
        return ResponseEntity(tutorSudaService.updateName(tutorSuda), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return tutorSudaService.delete(id)
    }
}