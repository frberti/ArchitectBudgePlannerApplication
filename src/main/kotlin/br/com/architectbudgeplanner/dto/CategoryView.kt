package br.com.architectbudgeplanner.dto

import br.com.architectbudgeplanner.model.CategorizedItemComposition

data class CategoryView (
    val id: Long?,
    val description: String,
    val acronym: String,
    val categorizedItens: List<CategorizedItemComposition>? = null
)
