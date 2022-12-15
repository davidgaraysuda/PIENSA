package com.example.convenios.service

import com.example.convenios.model.Carreras
import com.example.convenios.reposity.CarrerasReposity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class CarrerasService {
    @Autowired
    lateinit var carrerasRepository: CarrerasReposity

    fun save (carreras:Carreras):Carreras{
        return carrerasRepository.save(carreras)
    }
    fun list ():List<Carreras>{
        return carrerasRepository.findAll()
    }

    fun listById (id:Long?):Carreras{
        return carrerasRepository.findById(id)
    }


    fun update(carreras:Carreras):Carreras{
        try{
            carrerasRepository.findById(carreras.id)
                ?: throw Exception ("El Id no existe")
            return carrerasRepository.save(carreras)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(carreras:Carreras): Carreras {
        try{
            val response = carrerasRepository.findById(carreras.id)
                ?: throw Exception("ID no existe")
            response.apply {
                especialidad=carreras.especialidad
            }
            return carrerasRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        carrerasRepository.findById(id) ?:
        throw  Exception()
        carrerasRepository.deleteById(id!!)
        return true
    }
}