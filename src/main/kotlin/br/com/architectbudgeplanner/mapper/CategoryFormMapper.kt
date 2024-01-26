package br.com.architectbudgeplanner.mapper

import br.com.architectbudgeplanner.dto.CategoryForm
import br.com.architectbudgeplanner.model.Category
import org.springframework.stereotype.Component

@Component
class CategoryFormMapper: Mapper<CategoryForm, Category> {

    override fun map(t: CategoryForm): Category {
        return Category(
            id = null,
            description = t.description,
            acronym = t.acronym
        )
    }


}