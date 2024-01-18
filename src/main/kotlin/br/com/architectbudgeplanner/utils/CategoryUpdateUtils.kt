package br.com.architectbudgeplanner.utils

import br.com.architectbudgeplanner.dto.CategoryUpdateForm
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.model.Category
import org.springframework.stereotype.Component

@Component
class CategoryUpdateUtils : UpdateUtils<CategoryUpdateForm, Category> {

    override fun updateList(form: CategoryUpdateForm, list: MutableList<Category>): Category? {

        val category = list.firstOrNull { it.id == form.id }

        category?.let {
            list.remove(it)
            val categoryUpdated = Category(
                id = it.id,
                description = form.description,
                acronym = form.acronym
            )
            list.add(categoryUpdated)
            return categoryUpdated
        } ?: throw NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND)

    }

}