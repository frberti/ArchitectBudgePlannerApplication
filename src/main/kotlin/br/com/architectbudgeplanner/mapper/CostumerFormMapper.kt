package br.com.architectbudgeplanner.mapper

import br.com.architectbudgeplanner.dto.CostumerForm
import br.com.architectbudgeplanner.model.Costumer
import org.springframework.stereotype.Component

@Component
class CostumerFormMapper : Mapper<CostumerForm, Costumer> {

    override fun map(t: CostumerForm): Costumer {
        return Costumer(
            id = null,
            name = t.name,
            email = t.email,
            password = t.password
        )
    }


}