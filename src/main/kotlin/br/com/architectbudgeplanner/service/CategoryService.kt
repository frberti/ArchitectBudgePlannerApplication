package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.CategoryForm
import br.com.architectbudgeplanner.dto.CategoryUpdateForm
import br.com.architectbudgeplanner.dto.CategoryView
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.mapper.CategoryFormMapper
import br.com.architectbudgeplanner.mapper.CategoryViewMapper
import br.com.architectbudgeplanner.repository.CategoryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryViewMapper: CategoryViewMapper,
    private val categoryFormMapper: CategoryFormMapper,
    private val repository: CategoryRepository

) {

    fun getCategories(
        description: String?,
        acronym: String?,
        pageable: Pageable
    ): Page<CategoryView> = if (description == null && acronym == null) {
        repository.findAll(pageable)
    } else {
        repository.findByParams(description, acronym, pageable)
    }.map(categoryViewMapper::map)

    fun getCategoryById(id: Long): CategoryView {
        val category = repository.findById(id).orElseThrow { NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND) }
        return categoryViewMapper.map(category)
    }

    fun addCategory(form: CategoryForm): CategoryView {
        val category = categoryFormMapper.map(form)
        repository.save(category)
        return categoryViewMapper.map(category)
    }

    fun updateCategory(form: CategoryUpdateForm): CategoryView? {
        val category = repository.findById(form.id).orElseThrow { NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND) }
        category.description = form.description
        category.acronym = form.acronym
        return categoryViewMapper.map(category)
    }

    fun deleteCategory(id: Long) {
        repository.existsById(id).takeIf { it }?.run { repository.deleteById(id) } ?: throw NotFoundException(
            ErrorMessage.RESOURCE_NOT_FOUND
        )
    }
}