package br.com.architectbudgeplanner.repository

import br.com.architectbudgeplanner.model.CategorizedItemComposition
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CategorizedItemCompositionRepository : JpaRepository<CategorizedItemComposition, Long> {


    @Query(
        "SELECT cat " +
                "FROM CategorizedItemComposition cat " +
                "WHERE " +
                "(:description IS NULL OR LOWER(cat.description) LIKE LOWER(CONCAT('%', :description, '%'))) " +
                "AND " +
                "(:acronym IS NULL OR LOWER(cat.acronym) LIKE LOWER(CONCAT('%', :acronym, '%')))"
    )
    fun findByParams(
        @Param("description") description: String?,
        @Param("acronym") acronym: String?,
        pageable: Pageable): Page<CategorizedItemComposition>
}