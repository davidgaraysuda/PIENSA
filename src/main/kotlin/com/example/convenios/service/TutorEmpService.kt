package com.example.convenios.service

import com.example.convenios.model.TutorEmp
import com.example.convenios.reposity.TutorEmpReposity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class TutorEmpService {
    @Autowired
    lateinit var tutorEmpRepository: TutorEmpReposity

    fun save (tutorEmp:TutorEmp):TutorEmp{
        return tutorEmpRepository.save(tutorEmp)
    }
    fun list ():List<TutorEmp>{
        return tutorEmpRepository.findAll()
    }

    fun listById (id:Long?):TutorEmp{
        return tutorEmpRepository.findById(id)
    }


    fun update(tutorEmp:TutorEmp):TutorEmp{
        try{
            tutorEmpRepository.findById(tutorEmp.id)
                ?: throw Exception ("El Id no existe")
            return tutorEmpRepository.save(tutorEmp)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(tutorEmp:TutorEmp): TutorEmp {
        try{
            val response = tutorEmpRepository.findById(tutorEmp.id)
                ?: throw Exception("ID no existe")
            response.apply {
                funcion=tutorEmp.funcion
            }
            return tutorEmpRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        tutorEmpRepository.findById(id) ?:
        throw  Exception()
        tutorEmpRepository.deleteById(id!!)
        return true
    }
}