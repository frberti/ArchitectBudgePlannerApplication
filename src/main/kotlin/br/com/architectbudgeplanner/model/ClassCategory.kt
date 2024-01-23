package br.com.architectbudgeplanner.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class ClassCategory (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var description: String,
    var acronym: String,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @OneToMany(mappedBy = "classCategory")
    @JsonIgnore
    val categorizedItens: List<CategorizedItemComposition>? = ArrayList()
)