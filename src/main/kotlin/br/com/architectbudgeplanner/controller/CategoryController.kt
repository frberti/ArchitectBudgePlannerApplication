package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.CategoryForm
import br.com.architectbudgeplanner.dto.CategoryUpdateForm
import br.com.architectbudgeplanner.dto.CategoryView
import br.com.architectbudgeplanner.model.Category
import br.com.architectbudgeplanner.service.CategoryService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

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
    fun addCategory(@RequestBody @Valid category: CategoryForm) {
        service.addCategory(category)
    }

    @PutMapping
    fun updateCategory(@RequestBody @Valid category: CategoryUpdateForm) {
        service.updateCategory(category)
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long) {
        service.deleteCategory(id)
    }

}

