package com.example.convenios.controller

import com.example.convenios.model.TutorEmp
import com.example.convenios.service.TutorEmpService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/careras")

class TutorEmpController {
    @Autowired
    lateinit var tutorEmpService: TutorEmpService

    @PostMapping
    fun save (@RequestBody @Valid tutorEmp:TutorEmp): TutorEmp {
        return tutorEmpService.save(tutorEmp)
    }

    @GetMapping
    fun list ():List<TutorEmp>{
        return tutorEmpService.list()
    }

    @GetMapping("/{id}")
    fun listId(@PathVariable("id") id:Long):ResponseEntity<TutorEmp>{
        return ResponseEntity(tutorEmpService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid tutorEmp:TutorEmp):ResponseEntity<TutorEmp>{
        return ResponseEntity(tutorEmpService.update(tutorEmp), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid tutorEmp:TutorEmp): ResponseEntity<TutorEmp>{
        return ResponseEntity(tutorEmpService.updateName(tutorEmp), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return tutorEmpService.delete(id)
    }
}