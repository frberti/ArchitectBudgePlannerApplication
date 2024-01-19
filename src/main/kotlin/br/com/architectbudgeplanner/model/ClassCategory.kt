package br.com.architectbudgeplanner.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class ClassCategory (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var description: String,
    var acronym: String,
    @OneToMany(mappedBy = "classCategory")
    @JsonIgnore
    val categorizedItens: List<CategorizedItemComposition>? = ArrayList()

)