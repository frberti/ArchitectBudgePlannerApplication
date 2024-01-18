package br.com.architectbudgeplanner.utils

import br.com.architectbudgeplanner.dto.ClassCategoryUpdateForm
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.model.ClassCategory
import org.springframework.stereotype.Component

@Component
class ClassCategoryUpdateUtils : UpdateUtils<ClassCategoryUpdateForm, ClassCategory> {

    override fun updateList(form: ClassCategoryUpdateForm, list: MutableList<ClassCategory>): ClassCategory? {

        list.firstOrNull { it.id == form.id }?.let {
            list.remove(it)
            val classUpdated = ClassCategory(
                id = it.id,
                description = form.description,
                acronym = form.acronym
            )
            list.add(classUpdated)
            return classUpdated
        } ?: throw NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND)
    }

}