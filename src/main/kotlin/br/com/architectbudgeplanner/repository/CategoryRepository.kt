package br.com.architectbudgeplanner.repository

import br.com.architectbudgeplanner.model.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {

    fun findByDescriptionContainingIgnoreCaseOrAcronymContainingIgnoreCase(
        description: String?,
        acronym: String?,
        pageable: Pageable
    ): Page<Category>


}