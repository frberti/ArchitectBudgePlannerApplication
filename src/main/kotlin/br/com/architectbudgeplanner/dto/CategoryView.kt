package br.com.architectbudgeplanner.dto

import br.com.architectbudgeplanner.model.CategorizedItemComposition
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class CategoryView (
    val id: Long?,
    val description: String,
    val acronym: String,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    val createdAt: LocalDateTime,
    val categorizedItens: List<CategorizedItemComposition>? = null
)
