package com.example.convenios.service

import com.example.convenios.model.Convenio
import com.example.convenios.reposity.ConvenioReposity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class ConvenioService {
    @Autowired
    lateinit var convenioRepository: ConvenioReposity

    fun save (convenio:Convenio):Convenio{
        return convenioRepository.save(convenio)
    }
    fun list ():List<Convenio>{
        return convenioRepository.findAll()
    }

    fun listById (id:Long?):Convenio{
        return convenioRepository.findById(id)
    }


    fun update(convenio:Convenio):Convenio{
        try{
            convenioRepository.findById(convenio.id)
                ?: throw Exception ("El Id no existe")
            return convenioRepository.save(convenio)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(convenio:Convenio): Convenio {
        try{
            val response = convenioRepository.findById(convenio.id)
                ?: throw Exception("ID no existe")
            response.apply {
                stateCon=convenio.stateCon
            }
            return convenioRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        convenioRepository.findById(id) ?:
        throw  Exception()
        convenioRepository.deleteById(id!!)
        return true
    }
}