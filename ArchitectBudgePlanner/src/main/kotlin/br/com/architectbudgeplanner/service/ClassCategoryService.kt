package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.ClassCategoryForm
import br.com.architectbudgeplanner.dto.ClassCategoryView
import br.com.architectbudgeplanner.model.ClassCategory
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ClassCategoryService(
    private var list: MutableList<ClassCategory>,
    private val classCategoryViewMapper: ClassCategoryViewMapper,
    private val classCategoryFormMapper: ClassCategoryFormMapper
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
        val classCategory = list.stream().filter {
            it.id == id
        }.findFirst().get()
        return classCategoryViewMapper.map(classCategory)
    }

    fun addClass(dto: ClassCategoryForm) {
        val classCategory = classCategoryFormMapper.map(dto)
        classCategory.id = list.size.toLong() + 1
        list.add(classCategory)
    }
}
