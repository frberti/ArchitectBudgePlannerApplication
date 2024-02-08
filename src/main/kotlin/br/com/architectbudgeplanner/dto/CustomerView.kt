package br.com.architectbudgeplanner.dto

import br.com.architectbudgeplanner.model.Role
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class CustomerView(
    val id: Long?,
    val name: String,
    val email: String,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    val createdAt: LocalDateTime,
    //TODO: DEIXAR SERIALIZAR SOMENTE DURANTE OS TESTES
    val roles: Set<Role>
)
