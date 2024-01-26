package br.com.architectbudgeplanner.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Costumer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    val createdAt: LocalDateTime = LocalDateTime.now()
)