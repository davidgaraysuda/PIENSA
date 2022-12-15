package com.example.convenios.service

import com.example.convenios.model.Tareas
import com.example.convenios.reposity.TareasReposity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class TareasService {
    @Autowired
    lateinit var tareasRepository: TareasReposity

    fun save (tareas:Tareas):Tareas{
        return tareasRepository.save(tareas)
    }
    fun list ():List<Tareas>{
        return tareasRepository.findAll()
    }

    fun listById (id:Long?):Tareas{
        return tareasRepository.findById(id)
    }


    fun update(tareas:Tareas):Tareas{
        try{
            tareasRepository.findById(tareas.id)
                ?: throw Exception ("El Id no existe")
            return tareasRepository.save(tareas)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(tareas:Tareas): Tareas {
        try{
            val response = tareasRepository.findById(tareas.id)
                ?: throw Exception("ID no existe")
            response.apply {
                detalles=tareas.detalles
            }
            return tareasRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        tareasRepository.findById(id) ?:
        throw  Exception()
        tareasRepository.deleteById(id!!)
        return true
    }
}