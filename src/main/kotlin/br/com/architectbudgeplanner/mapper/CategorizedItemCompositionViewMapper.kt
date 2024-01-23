package br.com.architectbudgeplanner.mapper

import br.com.architectbudgeplanner.dto.CategorizedItemCompositionView
import br.com.architectbudgeplanner.model.CategorizedItemComposition
import org.springframework.stereotype.Component

@Component
class CategorizedItemCompositionViewMapper: Mapper<CategorizedItemComposition, CategorizedItemCompositionView> {

    override fun map(t: CategorizedItemComposition): CategorizedItemCompositionView {
        return CategorizedItemCompositionView(
            id = t.id,
            description = t.description,
            acronym = t.acronym,
            createdAt = t.createdAt,
            classCategory = t.classCategory,
            category = t.category
        )
    }
}