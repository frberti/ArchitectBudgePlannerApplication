package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.CategorizedItemCompositionForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionUpdateForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionView
import br.com.architectbudgeplanner.service.CategorizedItemCompositionService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/item-composition")
class CategorizedItemCompositionController(private val service: CategorizedItemCompositionService) {


    @GetMapping
    fun getItems(): List<CategorizedItemCompositionView> {
        return service.getItems()
    }

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): CategorizedItemCompositionView {
        return service.getItemById(id)
    }

    @PostMapping
    fun addItem(
        @RequestBody @Valid form: CategorizedItemCompositionForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CategorizedItemCompositionView?> {
        val itemCompositionView = service.addCategorizedItem(form)
        val uri = uriBuilder.path("/item-composition/${itemCompositionView.id}").build().toUri()
        return ResponseEntity.created(uri).body(itemCompositionView)
    }

    @PutMapping
    fun updateItem(@RequestBody @Valid form: CategorizedItemCompositionUpdateForm): ResponseEntity<CategorizedItemCompositionView?> {
        val itemCompositionView = service.updateCategorizedItem(form)
        return ResponseEntity.ok(itemCompositionView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteItem(@PathVariable id: Long) {
        service.deleteItem(id)
    }

}