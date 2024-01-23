package br.com.architectbudgeplanner.mapper

import br.com.architectbudgeplanner.dto.CategoryView
import br.com.architectbudgeplanner.model.Category
import org.springframework.stereotype.Component

@Component
class CategoryViewMapper: Mapper<Category, CategoryView> {

    override fun map(t: Category): CategoryView {
        return CategoryView(
            id = t.id,
            description = t.description,
            acronym = t.acronym,
            createdAt = t.createdAt,
            categorizedItens = t.categorizedItens
        )
    }
}