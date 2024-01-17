package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.CategoryForm
import br.com.architectbudgeplanner.dto.CategoryView
import br.com.architectbudgeplanner.mapper.CategoryFormMapper
import br.com.architectbudgeplanner.mapper.CategoryViewMapper
import br.com.architectbudgeplanner.model.Category
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CategoryService(
    private var list: MutableList<Category>,
    private var listItems: MutableList<Category>,
    private val categoryViewMapper: CategoryViewMapper,
    private val categoryFormMapper: CategoryFormMapper

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
}