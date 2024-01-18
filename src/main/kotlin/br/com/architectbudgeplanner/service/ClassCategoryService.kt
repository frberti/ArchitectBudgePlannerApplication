package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.ClassCategoryForm
import br.com.architectbudgeplanner.dto.ClassCategoryUpdateForm
import br.com.architectbudgeplanner.dto.ClassCategoryView
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.mocks.getClassesMock
import br.com.architectbudgeplanner.model.ClassCategory
import br.com.architectbudgeplanner.utils.ClassCategoryUpdateUtils
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ClassCategoryService(
    private var list: MutableList<ClassCategory>,
    private val classCategoryViewMapper: ClassCategoryViewMapper,
    private val classCategoryFormMapper: ClassCategoryFormMapper,
    private val utils: ClassCategoryUpdateUtils
) {


    init {
        list = getClassesMock().toMutableList()
    }

    fun getClasses(): List<ClassCategoryView> {
        return list.stream().map {
            classCategoryViewMapper.map(it)
        }.collect(Collectors.toList())
    }

    fun getClassById(id: Long): ClassCategoryView {
        val classCategory = list.firstOrNull {
            it.id == id
        }?: throw NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND)
        return classCategoryViewMapper.map(classCategory)
    }

    fun addClass(form: ClassCategoryForm) : ClassCategoryView {
        val classCategory = classCategoryFormMapper.map(form)
        classCategory.id = list.size.toLong() + 1
        list.add(classCategory)
        return classCategoryViewMapper.map(classCategory)
    }

    fun updateClass(form: ClassCategoryUpdateForm) : ClassCategoryView? {
        val classCategory = utils.updateList(form, list)
        return classCategory?.let {
            classCategoryViewMapper.map(classCategory)
        }
    }

    fun deleteClass(id: Long) {
        list.firstOrNull { it.id == id }?.let { list.remove(it) } ?: throw NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND)
    }


}
