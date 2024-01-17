package br.com.architectbudgeplanner.utils

import br.com.architectbudgeplanner.dto.CategorizedItemCompositionUpdateForm
import br.com.architectbudgeplanner.model.CategorizedItemComposition
import org.springframework.stereotype.Component


@Component
class CategorizedItemCompositionUpdateUtils : Utils<CategorizedItemCompositionUpdateForm, CategorizedItemComposition> {
    override fun updateList(
        form: CategorizedItemCompositionUpdateForm,
        list: MutableList<CategorizedItemComposition>
    ): CategorizedItemComposition? {
        val categorizedItem = list.firstOrNull { it.id == form.id }

        categorizedItem?.let {
            list.remove(it)
            val itemUpdated = CategorizedItemComposition(
                id = it.id,
                description = form.description,
                acronym = form.acronym,
                classCategory = it.classCategory,
                category = it.category
            )
            list.add(itemUpdated)
            return itemUpdated
        }
        return null
    }
}