package br.com.architectbudgeplanner.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class CostumerForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 150)
    val name: String,
    @field:NotEmpty
    val email: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 10)
    val password: String
)
