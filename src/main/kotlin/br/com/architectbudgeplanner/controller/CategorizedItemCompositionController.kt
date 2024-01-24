package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.CategorizedItemCompositionForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionUpdateForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionView
import br.com.architectbudgeplanner.service.CategorizedItemCompositionService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/item-composition")
class CategorizedItemCompositionController(private val service: CategorizedItemCompositionService) {


    @GetMapping
    fun getItems(
        @RequestParam(required = false) description: String?,
        @RequestParam(required = false) acronym: String?,
        @PageableDefault(size = 10, sort = ["createdAt"], direction = Sort.Direction.ASC) pageable: Pageable
    ): Page<CategorizedItemCompositionView> {
        return service.getItems(description, acronym, pageable)
    }

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): CategorizedItemCompositionView {
        return service.getItemById(id)
    }

    @PostMapping
    @Transactional
    fun addItem(
        @RequestBody @Valid form: CategorizedItemCompositionForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CategorizedItemCompositionView?> {
        val itemCompositionView = service.addItem(form)
        val uri = uriBuilder.path("/item-composition/${itemCompositionView.id}").build().toUri()
        return ResponseEntity.created(uri).body(itemCompositionView)
    }

    @PutMapping
    @Transactional
    fun updateItem(@RequestBody @Valid form: CategorizedItemCompositionUpdateForm): ResponseEntity<CategorizedItemCompositionView?> {
        val itemCompositionView = service.updateItem(form)
        return ResponseEntity.ok(itemCompositionView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteItem(@PathVariable id: Long) {
        service.deleteItem(id)
    }

}