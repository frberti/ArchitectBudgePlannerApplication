package br.com.architectbudgeplanner.repository

import br.com.architectbudgeplanner.model.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CategoryRepository : JpaRepository<Category, Long> {


    @Query(
        "SELECT c " +
                "FROM Category c " +
                "WHERE " +
                "(:description IS NULL OR LOWER(c.description) LIKE LOWER(CONCAT('%', :description, '%'))) " +
                "AND " +
                "(:acronym IS NULL OR LOWER(c.acronym) LIKE LOWER(CONCAT('%', :acronym, '%')))"
    )
    fun findByParams(
        @Param("description") description: String?,
        @Param("acronym") acronym: String?,
        pageable: Pageable
    ): Page<Category>

    /*
    Método equivalente ao findByParams, que utiliza o padrão de nomenclatura JPA para receber um parâmetro com seu valor
    parcial ou completo, caseSensitive, não obrigatório

    fun findByDescriptionContainingIgnoreCaseOrAcronymContainingIgnoreCase(
        description: String?,
        acronym: String?
    ): List<Category>
    */

}