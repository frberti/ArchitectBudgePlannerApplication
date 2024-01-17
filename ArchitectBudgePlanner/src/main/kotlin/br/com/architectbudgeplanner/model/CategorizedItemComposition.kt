package br.com.architectbudgeplanner.model

data class CategorizedItemComposition (
    var id: Long?,
    val description: String,
    val acronym: String,
    val classCategory: ClassCategory,
    val category: Category?
)