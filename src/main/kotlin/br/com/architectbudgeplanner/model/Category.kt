package br.com.architectbudgeplanner.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Category (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var description: String,
    var acronym: String,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    val categorizedItens: List<CategorizedItemComposition>? = ArrayList()
)