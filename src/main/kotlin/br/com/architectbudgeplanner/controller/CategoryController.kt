package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.CategoryForm
import br.com.architectbudgeplanner.dto.CategoryUpdateForm
import br.com.architectbudgeplanner.dto.CategoryView
import br.com.architectbudgeplanner.service.CategoryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/categories")
class CategoryController(private val service: CategoryService) {


    @GetMapping
    fun getCategories(): List<CategoryView> {
        return service.getCategories()
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): CategoryView {
        return service.getCategoryById(id)
    }

    @PostMapping
    fun addCategory(
        @RequestBody @Valid category: CategoryForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CategoryView?> {
        val categoryView = service.addCategory(category)
        val uri = uriBuilder.path("/categories/${categoryView.id}").build().toUri()
        return ResponseEntity.created(uri).body(categoryView)
    }

    @PutMapping
    fun updateCategory(@RequestBody @Valid category: CategoryUpdateForm): ResponseEntity<CategoryView?> {
        val categoryView = service.updateCategory(category)
        return ResponseEntity.ok(categoryView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategory(@PathVariable id: Long) {
        service.deleteCategory(id)
    }

}

