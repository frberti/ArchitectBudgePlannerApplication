package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.CategorizedItemCompositionForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionUpdateForm
import br.com.architectbudgeplanner.dto.CategorizedItemCompositionView
import br.com.architectbudgeplanner.exception.NotFoundException
import br.com.architectbudgeplanner.exception.message.ErrorMessage
import br.com.architectbudgeplanner.mapper.CategorizedItemCompositionFormMapper
import br.com.architectbudgeplanner.mapper.CategorizedItemCompositionViewMapper
import br.com.architectbudgeplanner.repository.CategorizedItemCompositionRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CategorizedItemCompositionService(
    private val repository: CategorizedItemCompositionRepository,
    private val categorizedItemCompositionViewMapper: CategorizedItemCompositionViewMapper,
    private val categorizedItemCompositionFormMapper: CategorizedItemCompositionFormMapper,
) {

    fun getItems(
        description: String?,
        acronym: String?,
        pageable: Pageable
    ): Page<CategorizedItemCompositionView> = if (description == null && acronym == null) {
        repository.findAll(pageable)
    } else {
        repository.findByParams(description, acronym, pageable)
    }.map(categorizedItemCompositionViewMapper::map)


    fun getItemById(id: Long): CategorizedItemCompositionView {
        val categorizedItem = repository.findById(id).orElseThrow { NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND) }
        return categorizedItemCompositionViewMapper.map(categorizedItem)
    }

    fun addItem(form: CategorizedItemCompositionForm): CategorizedItemCompositionView {
        val item = categorizedItemCompositionFormMapper.map(form)
        repository.save(item)
        return categorizedItemCompositionViewMapper.map(item)
    }

    fun updateItem(form: CategorizedItemCompositionUpdateForm): CategorizedItemCompositionView? {
        val item = repository.findById(form.id).orElseThrow { NotFoundException(ErrorMessage.RESOURCE_NOT_FOUND) }
        item.description = form.description
        item.acronym = form.acronym
        return categorizedItemCompositionViewMapper.map(item)
    }

    fun deleteItem(id: Long) {
        repository.existsById(id).takeIf { it }?.run { repository.deleteById(id) } ?: throw NotFoundException(
            ErrorMessage.RESOURCE_NOT_FOUND
        )
    }
}