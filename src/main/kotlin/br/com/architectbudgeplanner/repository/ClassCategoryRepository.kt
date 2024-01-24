package br.com.architectbudgeplanner.repository

import br.com.architectbudgeplanner.model.ClassCategory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.web.bind.annotation.RequestParam

interface ClassCategoryRepository : JpaRepository<ClassCategory, Long> {

    @Query(
        "SELECT cla " +
                "FROM ClassCategory cla " +
                "WHERE " +
                "(:description IS NULL OR LOWER(cla.description) LIKE LOWER(CONCAT('%', :description, '%'))) " +
                "AND " +
                "(:acronym IS NULL OR LOWER(cla.acronym) LIKE LOWER(CONCAT('%', :acronym, '%')))"
    )
    fun findByParams(
        @RequestParam description: String?,
        @RequestParam acronym: String?,
        pageable: Pageable
    ): Page<ClassCategory>

}