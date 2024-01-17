package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.CategorizedItemCompositionForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionUpdateForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionView
import br.com.architectbudgeplanner.service.CategorizedItemCompositionService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

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
    fun addItem(@RequestBody @Valid form: CategorizedItemCompositionForm) {
        service.addCategorizedItem(form)
    }

    @PutMapping
    fun updateItem(@RequestBody @Valid form: CategorizedItemCompositionUpdateForm) {
        service.updateCategorizedItem(form)
    }

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long) {
        service.deleteItem(id)
    }

}