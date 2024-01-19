package br.com.architectbudgeplanner.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Category (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var description: String,
    var acronym: String,
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    val categorizedItens: List<CategorizedItemComposition>? = ArrayList()
)