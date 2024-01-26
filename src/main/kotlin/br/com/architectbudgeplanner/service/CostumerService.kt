package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.config.UserDetail
import br.com.architectbudgeplanner.dto.CostumerForm
import br.com.architectbudgeplanner.dto.CostumerView
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.mapper.CostumerFormMapper
import br.com.architectbudgeplanner.mapper.CostumerViewMapper
import br.com.architectbudgeplanner.repository.CostumerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CostumerService(
    private val repository: CostumerRepository,
    private val costumerFormMapper: CostumerFormMapper,
    private val costumerViewMapper: CostumerViewMapper,
    private val passwordEncoder: PasswordEncoder

) : UserDetailsService {

    fun getCostumers(name: String?, email: String?, pageable: Pageable): Page<CostumerView> =
        if (name == null && email == null) {
            repository.findAll(pageable)
        } else {
            repository.findByParams(name, email, pageable)
        }.map(costumerViewMapper::map)

    fun getCostumerById(id: Long): CostumerView {
        val user = repository.getReferenceById(id)
        return costumerViewMapper.map(user)
    }

    //TODO - CORRIGIR UNAUTHORIZED AO FAZER POST
    fun addCostumer(form: CostumerForm): CostumerView {
        val user = costumerFormMapper.map(form)
        repository.save(user)
        return costumerViewMapper.map(user)
    }

    override fun loadUserByUsername(username: String?): UserDetail {
        val user = repository.findByEmail(username) ?: throw NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND)
        return UserDetail(user)
    }


}