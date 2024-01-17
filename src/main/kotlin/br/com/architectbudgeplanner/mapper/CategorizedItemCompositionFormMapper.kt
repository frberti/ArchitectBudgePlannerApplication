package br.com.architectbudgeplanner.mapper

import br.com.architectbudgeplanner.dto.CategorizedItemCompositionForm
import br.com.architectbudgeplanner.model.CategorizedItemComposition
import br.com.architectbudgeplanner.model.Category
import br.com.architectbudgeplanner.model.ClassCategory
import br.com.architectbudgeplanner.service.CategoryService
import br.com.architectbudgeplanner.service.ClassCategoryService
import org.springframework.stereotype.Component

@Component
class CategorizedItemCompositionFormMapper(
    private val classService: ClassCategoryService,
    private val categoryService: CategoryService
): Mapper<CategorizedItemCompositionForm, CategorizedItemComposition> {
    
    override fun map(t: CategorizedItemCompositionForm): CategorizedItemComposition {
        return CategorizedItemComposition(
            id = null,
            description = t.description,
            acronym = t.acronym,
            classCategory = ClassCategory(
                id = classService.getClassById(t.classCategoryId).id,
                description = classService.getClassById(t.classCategoryId).description,
                acronym = classService.getClassById(t.classCategoryId).acronym
            ),
            category = Category(
                id = categoryService.getCategoryById(t.categoryId).id,
                description = categoryService.getCategoryById(t.categoryId).description,
                acronym = categoryService.getCategoryById(t.categoryId).acronym
            )
        )
    }


}