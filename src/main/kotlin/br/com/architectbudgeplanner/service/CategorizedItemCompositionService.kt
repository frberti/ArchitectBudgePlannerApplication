package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.CategorizedItemCompositionForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionUpdateForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionView
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.mapper.CategorizedItemCompositionFormMapper
import br.com.architectbudgeplanner.mapper.CategorizedItemCompositionViewMapper
import br.com.architectbudgeplanner.mocks.getItensMock
import br.com.architectbudgeplanner.model.CategorizedItemComposition
import br.com.architectbudgeplanner.utils.CategorizedItemCompositionUpdateUtils
import org.springframework.stereotype.Service

@Service
class CategorizedItemCompositionService(
    private var list: MutableList<CategorizedItemComposition>,
    private val categorizedItemCompositionViewMapper: CategorizedItemCompositionViewMapper,
    private val categorizedItemCompositionFormMapper: CategorizedItemCompositionFormMapper,
    private val utils: CategorizedItemCompositionUpdateUtils
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
        val categorizedItem = list.firstOrNull {
            id == it.id
        } ?: throw NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND)
        return categorizedItemCompositionViewMapper.map(categorizedItem)
    }

    fun addCategorizedItem(form: CategorizedItemCompositionForm): CategorizedItemCompositionView {
        val itemCategorized = categorizedItemCompositionFormMapper.map(form)
        itemCategorized.id = list.size.toLong() + 1
        list.add(itemCategorized)
        return categorizedItemCompositionViewMapper.map(itemCategorized)
    }

    fun updateCategorizedItem(form: CategorizedItemCompositionUpdateForm): CategorizedItemCompositionView? {
        val itemComposition = utils.updateList(form, list)
        return itemComposition?.let {
            categorizedItemCompositionViewMapper.map(itemComposition)
        }
    }

    fun deleteItem(id: Long) {
        list.firstOrNull { it.id == id }?.let { list.remove(it) }
            ?: throw NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND)
    }
}