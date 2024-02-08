package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.CostumerForm
import br.com.architectbudgeplanner.dto.CustomerView
import br.com.architectbudgeplanner.service.CustomerService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/customers")
class CustomerController(private val service: CustomerService) {


    @GetMapping
    @Cacheable("customers")
    fun getCustomers(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) email: String?,
        @PageableDefault(size = 20, sort = ["createdAt"], direction = Sort.Direction.ASC) pageable: Pageable
    ): Page<CustomerView> {
        return service.getCustomers(name, email, pageable)
    }

    @GetMapping("/{id}")
    fun getCostumerById(@PathVariable id: Long): CustomerView {
        return service.getCustomerById(id)
    }

    @PostMapping
    @CacheEvict(value = ["customers"], allEntries = true)
    @Transactional
    fun addCostumer(
        @RequestBody @Valid form: CostumerForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CustomerView?> {
        val customerView = service.addCostumer(form)
        val uri = uriBuilder.path("/customers/${customerView.id}").build().toUri()
        return ResponseEntity.created(uri).body(customerView)
    }

}

