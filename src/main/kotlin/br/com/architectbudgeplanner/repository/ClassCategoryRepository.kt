package br.com.architectbudgeplanner.repository

import br.com.architectbudgeplanner.model.ClassCategory
import org.springframework.data.jpa.repository.JpaRepository

interface ClassCategoryRepository : JpaRepository<ClassCategory, Long> {
}