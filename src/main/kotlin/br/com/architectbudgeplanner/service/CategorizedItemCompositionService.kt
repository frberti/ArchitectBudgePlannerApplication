package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.CategorizedItemCompositionForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionUpdateForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionView
import br.com.architectbudgeplanner.mapper.CategorizedItemCompositionFormMapper
import br.com.architectbudgeplanner.mapper.CategorizedItemCompositionViewMapper
import br.com.architectbudgeplanner.model.CategorizedItemComposition
import org.springframework.stereotype.Service

@Service
class CategorizedItemCompositionService(
    private var list: MutableList<CategorizedItemComposition>,
    private val categorizedItemCompositionViewMapper: CategorizedItemCompositionViewMapper,
    private val categorizedItemCompositionFormMapper: CategorizedItemCompositionFormMapper,
) {


    init {
        list = getItensMock().toMutableList()
    }

    fun getItems(): List<CategorizedItemCompositionView> {
        return list.map {
            categorizedItemCompositionViewMapper.map(it)
        }
    }

    fun getItemById(id: Long): CategorizedItemCompositionView {
        val categorizedItem = list.first { item ->
            id == item.id
        }
        return categorizedItemCompositionViewMapper.map(categorizedItem)
    }

    fun addCategorizedItem(form: CategorizedItemCompositionForm) {
        val itemCategorized = categorizedItemCompositionFormMapper.map(form)
        itemCategorized.id = list.size.toLong() + 1
        list.add(itemCategorized)
    }

    fun updateCategorizedItem(form: CategorizedItemCompositionUpdateForm) {
        val updatedList = list.toMutableList()

        val categorizedItem = updatedList.firstOrNull { it.id == form.id }

        categorizedItem?.let {
            updatedList.remove(it)
            updatedList.add(
                CategorizedItemComposition(
                    id = it.id,
                    description = form.description,
                    acronym = form.acronym,
                    classCategory = it.classCategory,
                    category = it.category
                )
            )
            list.clear()
            list.addAll(updatedList)
        }
    }

    fun deleteItem(id: Long) {
        list.removeIf { it.id == id }
    }
}