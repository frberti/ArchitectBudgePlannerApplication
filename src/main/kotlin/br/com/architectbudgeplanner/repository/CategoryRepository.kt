package br.com.architectbudgeplanner.repository

import br.com.architectbudgeplanner.model.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}