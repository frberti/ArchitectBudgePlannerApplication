package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.CategoryForm
import br.com.architectbudgeplanner.dto.CategoryUpdateForm
import br.com.architectbudgeplanner.dto.CategoryView
import br.com.architectbudgeplanner.mapper.CategoryFormMapper
import br.com.architectbudgeplanner.mapper.CategoryViewMapper
import br.com.architectbudgeplanner.model.Category
import br.com.architectbudgeplanner.utils.CategoryUpdateUtils
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CategoryService(
    private var list: MutableList<Category>,
    private var listItems: MutableList<Category>,
    private val categoryViewMapper: CategoryViewMapper,
    private val categoryFormMapper: CategoryFormMapper,
    private val utils: CategoryUpdateUtils

) {

    init {
        list = getCategoriesMock().toMutableList()
    }

    fun getCategories(): List<CategoryView> {
        return list.stream().map {
            categoryViewMapper.map(it)
        }.collect(Collectors.toList())

    }

    fun getCategoryById(id: Long): CategoryView {
        val category = list.stream().filter { element ->
            element.id == id
        }.findFirst().get()

        return categoryViewMapper.map(category)
    }

    fun addCategory(form: CategoryForm) {
        val category = categoryFormMapper.map(form)
        category.id = list.size.toLong() + 1
        list.add(category)
    }

    fun updateCategory(form: CategoryUpdateForm) {
        utils.updateList(form, list)
    }

    fun deleteCategory(id: Long) {
        list.removeIf { id == it.id}
    }
}