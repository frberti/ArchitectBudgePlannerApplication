package br.com.architectbudgeplanner.utils

import br.com.architectbudgeplanner.dto.ClassCategoryUpdateForm
import br.com.architectbudgeplanner.model.ClassCategory
import org.springframework.stereotype.Component

@Component
class ClassCategoryUpdateUtils: Utils<ClassCategoryUpdateForm, ClassCategory> {

    override fun updateList(form: ClassCategoryUpdateForm, list: MutableList<ClassCategory>) {

        val classCategory = list.firstOrNull { it.id == form.id }

        classCategory?.let {
            list.remove(it)
            list.add(
                ClassCategory(
                    id = it.id,
                    description = form.description,
                    acronym = form.acronym
                )
            )
        }
    }

}