package br.com.architectbudgeplanner.mapper

import br.com.architectbudgeplanner.dto.CostumerForm
import br.com.architectbudgeplanner.model.Customer
import org.springframework.stereotype.Component

@Component
class CustomerFormMapper : Mapper<CostumerForm, Customer> {

    override fun map(t: CostumerForm): Customer {
        return Customer(
            id = null,
            name = t.name,
            email = t.email,
            password = t.password
        )
    }


}