package br.com.architectbudgeplanner.model

data class Category (
    var id: Long?,
    val description: String,
    val acronym: String,
    val categorizedItens: List<CategorizedItemComposition>? = null
)