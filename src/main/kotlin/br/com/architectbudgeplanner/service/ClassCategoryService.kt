package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.ClassCategoryForm
import br.com.architectbudgeplanner.dto.ClassCategoryUpdateForm
import br.com.architectbudgeplanner.dto.ClassCategoryView
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.mapper.ClassCategoryFormMapper
import br.com.architectbudgeplanner.mapper.ClassCategoryViewMapper
import br.com.architectbudgeplanner.repository.ClassCategoryRepository
import org.springframework.stereotype.Service

@Service
class ClassCategoryService(
    private var repository: ClassCategoryRepository,
    private val classCategoryViewMapper: ClassCategoryViewMapper,
    private val classCategoryFormMapper: ClassCategoryFormMapper,
) {

    fun getClasses(): List<ClassCategoryView> {
        return repository.findAll().map {
            classCategoryViewMapper.map(it)
        }
    }

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
        return classCategoryViewMapper.map(classCategory)
    }

    fun deleteClass(id: Long) {
        repository.existsById(id).takeIf { it }?.run { repository.deleteById(id) } ?: throw NotFoundException(
            ErrorMessage.RESOURCE_NOT_FOUND
        )
    }

}
