package br.com.architectbudgeplanner.mapper

import br.com.architectbudgeplanner.dto.CostumerView
import br.com.architectbudgeplanner.model.Costumer
import org.springframework.stereotype.Component

@Component
class CostumerViewMapper : Mapper<Costumer, CostumerView> {

    override fun map(t: Costumer): CostumerView {
        return CostumerView(
            id = t.id,
            name = t.name,
            email = t.email,
            createdAt = t.createdAt
        )
    }
}