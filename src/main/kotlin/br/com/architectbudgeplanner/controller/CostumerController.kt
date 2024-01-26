package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.CostumerForm
import br.com.architectbudgeplanner.dto.CostumerView
import br.com.architectbudgeplanner.service.CostumerService
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
@RequestMapping("/costumers")
class CostumerController(private val service: CostumerService) {


    @GetMapping
    @Cacheable("costumers")
    fun getCostumers(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) email: String?,
        @PageableDefault(size = 20, sort = ["createdAt"], direction = Sort.Direction.ASC) pageable: Pageable
    ): Page<CostumerView> {
        return service.getCostumers(name, email, pageable)
    }

    @GetMapping("/{id}")
    fun getCostumerById(@PathVariable id: Long): CostumerView {
        return service.getCostumerById(id)
    }

    //TODO FALTA CONFIGURAR O MÉTODO POST COM AUTENTICAÇÃO
    @PostMapping
    @CacheEvict(value = ["costumers"], allEntries = true)
    @Transactional
    fun addCostumer(
        @RequestBody @Valid form: CostumerForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CostumerView?> {
        val costumerView = service.addCostumer(form)
        val uri = uriBuilder.path("/costumers/${costumerView.id}").build().toUri()
        return ResponseEntity.created(uri).body(costumerView)
    }

}

