package com.example.convenios.service

import com.example.convenios.model.Direccion
import com.example.convenios.reposity.DireccionReposity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class DireccionService {
    @Autowired
    lateinit var direccionRepository: DireccionReposity

    fun save (direccion: Direccion):Direccion{
        return direccionRepository.save(direccion)
    }
    fun list ():List<Direccion>{
        return direccionRepository.findAll()
    }

    fun listById (id:Long?):Direccion{
        return direccionRepository.findById(id)
    }


    fun update(direccion:Direccion):Direccion{
        try{
            direccionRepository.findById(direccion.id)
                ?: throw Exception ("El Id no existe")
            return direccionRepository.save(direccion)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(direccion:Direccion): Direccion {
        try{
            val response = direccionRepository.findById(direccion.id)
                ?: throw Exception("ID no existe")
            response.apply {
                dir=direccion.dir
            }
            return direccionRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        direccionRepository.findById(id) ?:
        throw  Exception()
        direccionRepository.deleteById(id!!)
        return true
    }
}