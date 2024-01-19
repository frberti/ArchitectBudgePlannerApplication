package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.CategoryForm
import br.com.architectbudgeplanner.dto.CategoryUpdateForm
import br.com.architectbudgeplanner.dto.CategoryView
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.mapper.CategoryFormMapper
import br.com.architectbudgeplanner.mapper.CategoryViewMapper
import br.com.architectbudgeplanner.mocks.getCategoriesMock
import br.com.architectbudgeplanner.model.Category
import br.com.architectbudgeplanner.repository.CategoryRepository
import br.com.architectbudgeplanner.utils.CategoryUpdateUtils
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CategoryService(
    private val categoryViewMapper: CategoryViewMapper,
    private val categoryFormMapper: CategoryFormMapper,
    private val repository: CategoryRepository

) {

    fun getCategories(): List<CategoryView> {
        return repository.findAll().map {
            categoryViewMapper.map(it)
        }
    }

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