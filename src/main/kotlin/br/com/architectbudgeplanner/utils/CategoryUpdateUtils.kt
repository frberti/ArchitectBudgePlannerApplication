package br.com.architectbudgeplanner.utils

import br.com.architectbudgeplanner.dto.CategoryUpdateForm
import br.com.architectbudgeplanner.model.Category
import org.springframework.stereotype.Component

@Component
class CategoryUpdateUtils: Utils<CategoryUpdateForm, Category> {

    override fun updateList(form: CategoryUpdateForm, list: MutableList<Category>) {

        val category = list.firstOrNull { it.id == form.id }

        category?.let {
            list.remove(it)
            list.add(
                Category(
                    id = it.id,
                    description = form.description,
                    acronym = form.acronym
                )
            )
        }
    }

}