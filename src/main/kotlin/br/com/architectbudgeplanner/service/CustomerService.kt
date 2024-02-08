package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.config.UserDetail
import br.com.architectbudgeplanner.dto.CostumerForm
import br.com.architectbudgeplanner.dto.CustomerView
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.mapper.CustomerFormMapper
import br.com.architectbudgeplanner.mapper.CustomerViewMapper
import br.com.architectbudgeplanner.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val repository: CustomerRepository,
    private val customerFormMapper: CustomerFormMapper,
    private val customerViewMapper: CustomerViewMapper

) : UserDetailsService {

    fun getCustomers(name: String?, email: String?, pageable: Pageable): Page<CustomerView> =
        if (name == null && email == null) {
            repository.findAll(pageable)
        } else {
            repository.findByParams(name, email, pageable)
        }.map(customerViewMapper::map)

    fun getCustomerById(id: Long): CustomerView {
        val user = repository.getReferenceById(id)
        return customerViewMapper.map(user)
    }

    fun addCostumer(form: CostumerForm): CustomerView {
        val user = customerFormMapper.map(form)
        repository.save(user)
        return customerViewMapper.map(user)
    }

    override fun loadUserByUsername(username: String?): UserDetail {
        val user = repository.findByEmail(username) ?: throw NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND)
        return UserDetail(user)
    }


}