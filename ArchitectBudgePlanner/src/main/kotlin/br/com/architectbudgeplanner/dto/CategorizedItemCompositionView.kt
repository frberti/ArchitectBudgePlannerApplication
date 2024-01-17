package br.com.architectbudgeplanner.dto

import br.com.architectbudgeplanner.model.Category
import br.com.architectbudgeplanner.model.ClassCategory

data class CategorizedItemCompositionView (
    val id: Long?,
    val description: String,
    val acronym: String,
    val classCategory: ClassCategory,
    val category: Category?
)