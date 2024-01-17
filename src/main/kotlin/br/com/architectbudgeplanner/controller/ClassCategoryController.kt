package br.com.architectbudgeplanner.controller

import br.com.architectbudgeplanner.dto.ClassCategoryForm
import br.com.architectbudgeplanner.dto.ClassCategoryUpdateForm
import br.com.architectbudgeplanner.dto.ClassCategoryView
import br.com.architectbudgeplanner.service.ClassCategoryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
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