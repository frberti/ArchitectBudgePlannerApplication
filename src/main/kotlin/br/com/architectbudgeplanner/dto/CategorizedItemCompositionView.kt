package br.com.architectbudgeplanner.dto

import br.com.architectbudgeplanner.model.Category
import br.com.architectbudgeplanner.model.ClassCategory
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class CategorizedItemCompositionView (
    val id: Long?,
    val description: String,
    val acronym: String,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    val createdAt: LocalDateTime,
    val classCategory: ClassCategory,
    val category: Category?
)