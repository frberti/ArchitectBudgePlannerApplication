package br.com.architectbudgeplanner.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class CategorizedItemComposition (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var description: String,
    var acronym: String,
    @ManyToOne
    val classCategory: ClassCategory,
    @ManyToOne
    @JsonIgnore
    val category: Category?
)