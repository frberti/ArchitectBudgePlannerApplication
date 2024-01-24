package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.CategoryForm
import br.com.architectbudgeplanner.dto.CategoryUpdateForm
import br.com.architectbudgeplanner.dto.CategoryView
import br.com.architectbudgeplanner.service.CategoryService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/categories")
class CategoryController(private val service: CategoryService) {


    @GetMapping
    fun getCategories(
        @RequestParam(required = false) description: String?,
        @RequestParam(required = false) acronym: String?,
        @PageableDefault(size = 10) pageable: Pageable): Page<CategoryView> {
        return service.getCategories(description, acronym, pageable)
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): CategoryView {
        return service.getCategoryById(id)
    }

    @PostMapping
    @Transactional
    fun addCategory(
        @RequestBody @Valid category: CategoryForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CategoryView?> {
        val categoryView = service.addCategory(category)
        val uri = uriBuilder.path("/categories/${categoryView.id}").build().toUri()
        return ResponseEntity.created(uri).body(categoryView)
    }

    @PutMapping
    @Transactional
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

