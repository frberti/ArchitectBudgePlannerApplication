package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.ClassCategoryForm
import br.com.architectbudgeplanner.dto.ClassCategoryView
import br.com.architectbudgeplanner.model.ClassCategory
import br.com.architectbudgeplanner.service.ClassCategoryService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/classes")
class ClassCategoryController(private val service: ClassCategoryService) {


    @GetMapping
    fun getClasses(): List<ClassCategoryView> {
        return service.getClasses()
    }

    @PostMapping
    fun addClass(@RequestBody @Valid classCategory: ClassCategoryForm) {
        service.addClass(classCategory)
    }

}