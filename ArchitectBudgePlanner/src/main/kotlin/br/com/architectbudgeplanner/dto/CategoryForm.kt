package br.com.architectbudgeplanner.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class CategoryForm (
    @field:NotEmpty
    @field:Size(min = 5, max = 150)
    val description: String,
    @field:NotEmpty
    @field:Size(min = 3, max = 5)
    val acronym: String
)