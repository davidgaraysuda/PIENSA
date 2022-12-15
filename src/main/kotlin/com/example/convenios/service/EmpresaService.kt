package com.example.convenios.service

import com.example.convenios.model.Empresa
import com.example.convenios.reposity.EmpresaReposity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class EmpresaService {
    @Autowired
    lateinit var empresaRepository: EmpresaReposity

    fun save (empresa:Empresa):Empresa{
        return empresaRepository.save(empresa)
    }
    fun list ():List<Empresa>{
        return empresaRepository.findAll()
    }

    fun listById (id:Long?):Empresa{
        return empresaRepository.findById(id)
    }


    fun update(empresa:Empresa):Empresa{
        try{
            empresaRepository.findById(empresa.id)
                ?: throw Exception ("El Id no existe")
            return empresaRepository.save(empresa)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(empresa:Empresa): Empresa {
        try{
            val response = empresaRepository.findById(empresa.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nameEmp=empresa.nameEmp
            }
            return empresaRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        empresaRepository.findById(id) ?:
        throw  Exception()
        empresaRepository.deleteById(id!!)
        return true
    }
}