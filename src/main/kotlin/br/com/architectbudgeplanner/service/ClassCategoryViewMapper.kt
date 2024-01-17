package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.ClassCategoryView
import br.com.architectbudgeplanner.mapper.Mapper
import br.com.architectbudgeplanner.model.ClassCategory
import org.springframework.stereotype.Component

@Component
class ClassCategoryViewMapper: Mapper<ClassCategory, ClassCategoryView> {

    override fun map(t: ClassCategory): ClassCategoryView {
        return ClassCategoryView(
            id = t.id,
            description = t.description,
            acronym = t.acronym
        )
    }
}