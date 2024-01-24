package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.ClassCategoryForm
import br.com.architectbudgeplanner.dto.ClassCategoryUpdateForm
import br.com.architectbudgeplanner.dto.ClassCategoryView
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.mapper.ClassCategoryFormMapper
import br.com.architectbudgeplanner.mapper.ClassCategoryViewMapper
import br.com.architectbudgeplanner.repository.ClassCategoryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ClassCategoryService(
    private var repository: ClassCategoryRepository,
    private val classCategoryViewMapper: ClassCategoryViewMapper,
    private val classCategoryFormMapper: ClassCategoryFormMapper,
) {

    fun getClasses(
        description: String?,
        acronym: String?,
        pageable: Pageable
        ): Page<ClassCategoryView> =
        if (description == null && acronym == null) {
            repository.findAll(pageable)
        } else {
            repository.findByParams(description, acronym, pageable)
        }.map(classCategoryViewMapper::map)

    fun getClassById(id: Long): ClassCategoryView {
        val classCategory = repository.findById(id).orElseThrow { NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND) }
        return classCategoryViewMapper.map(classCategory)
    }

    fun addClass(form: ClassCategoryForm): ClassCategoryView {
        val classCategory = classCategoryFormMapper.map(form)
        repository.save(classCategory)
        return classCategoryViewMapper.map(classCategory)
    }

    fun updateClass(form: ClassCategoryUpdateForm): ClassCategoryView? {
        val classCategory =
            repository.findById(form.id).orElseThrow { NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND) }
            classCategory.description = form.description
            classCategory.acronym = form.acronym
        return classCategoryViewMapper.map(classCategory)
    }

    fun deleteClass(id: Long) {
        repository.existsById(id).takeIf { it }?.run { repository.deleteById(id) } ?: throw NotFoundException(
            ErrorMessage.RESOURCE_NOT_FOUND
        )
    }

}
