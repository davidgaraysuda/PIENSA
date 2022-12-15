package com.example.convenios.service

import com.example.convenios.model.TutorSuda
import com.example.convenios.reposity.TutorSudaReposity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class TutorSudaService {
    @Autowired
    lateinit var tutorSudaRepository: TutorSudaReposity

    fun save (tutorSuda:TutorSuda):TutorSuda{
        return tutorSudaRepository.save(tutorSuda)
    }
    fun list ():List<TutorSuda>{
        return tutorSudaRepository.findAll()
    }

    fun listById (id:Long?):TutorSuda{
        return tutorSudaRepository.findById(id)
    }


    fun update(tutorSuda:TutorSuda):TutorSuda{
        try{
            tutorSudaRepository.findById(tutorSuda.id)
                ?: throw Exception ("El Id no existe")
            return tutorSudaRepository.save(tutorSuda)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(tutorSuda:TutorSuda): TutorSuda {
        try{
            val response = tutorSudaRepository.findById(tutorSuda.id)
                ?: throw Exception("ID no existe")
            response.apply {
                rol=tutorSuda.rol
            }
            return tutorSudaRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        tutorSudaRepository.findById(id) ?:
        throw  Exception()
        tutorSudaRepository.deleteById(id!!)
        return true
    }
}