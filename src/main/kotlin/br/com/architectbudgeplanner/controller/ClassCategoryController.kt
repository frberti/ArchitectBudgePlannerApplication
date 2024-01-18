package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.ClassCategoryForm
import br.com.architectbudgeplanner.dto.ClassCategoryUpdateForm
import br.com.architectbudgeplanner.dto.ClassCategoryView
import br.com.architectbudgeplanner.service.ClassCategoryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/classes")
class ClassCategoryController(
    private val service: ClassCategoryService
) {


    @GetMapping
    fun getClasses(): List<ClassCategoryView> {
        return service.getClasses()
    }

    @GetMapping("/{id}")
    fun getClassById(@PathVariable id: Long): ClassCategoryView {
        return service.getClassById(id)
    }

    @PostMapping
    fun addClass(
        @RequestBody @Valid form: ClassCategoryForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ClassCategoryView?> {
        val classView = service.addClass(form)
        val uri = uriBuilder.path("/classes/${classView.id}").build().toUri()
        return ResponseEntity.created(uri).body(classView)
    }

    @PutMapping
    fun updateClass(@RequestBody form: ClassCategoryUpdateForm): ResponseEntity<ClassCategoryView?> {
        val classView = service.updateClass(form)
        return ResponseEntity.ok(classView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteClass(@PathVariable id: Long) {
        service.deleteClass(id)
    }

}