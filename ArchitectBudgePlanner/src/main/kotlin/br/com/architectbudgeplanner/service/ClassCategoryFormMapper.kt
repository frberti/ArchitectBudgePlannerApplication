package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.dto.ClassCategoryForm
import br.com.architectbudgeplanner.mapper.Mapper
import br.com.architectbudgeplanner.model.ClassCategory
import org.springframework.stereotype.Component

@Component
class ClassCategoryFormMapper : Mapper<ClassCategoryForm, ClassCategory> {

    override fun map(t: ClassCategoryForm): ClassCategory {
        return ClassCategory(
            id = null,
            description = t.description,
            acronym = t.acronym
        )
    }


}