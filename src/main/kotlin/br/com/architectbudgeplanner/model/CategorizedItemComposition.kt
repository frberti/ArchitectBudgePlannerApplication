package br.com.architectbudgeplanner.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class CategorizedItemComposition (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var description: String,
    var acronym: String,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val classCategory: ClassCategory,
    @ManyToOne
    @JsonIgnore
    val category: Category?
)