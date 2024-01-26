package br.com.architectbudgeplanner.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class CostumerView(
    val id: Long?,
    val name: String,
    val email: String,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    val createdAt: LocalDateTime,
)
