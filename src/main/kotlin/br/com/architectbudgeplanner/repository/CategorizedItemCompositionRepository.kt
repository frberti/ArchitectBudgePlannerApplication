package br.com.architectbudgeplanner.repository

import br.com.architectbudgeplanner.model.CategorizedItemComposition
import org.springframework.data.jpa.repository.JpaRepository

interface CategorizedItemCompositionRepository : JpaRepository<CategorizedItemComposition, Long> {
}