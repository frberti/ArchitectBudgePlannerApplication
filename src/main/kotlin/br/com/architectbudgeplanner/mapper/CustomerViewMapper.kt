package br.com.architectbudgeplanner.mapper

import br.com.architectbudgeplanner.dto.CustomerView
import br.com.architectbudgeplanner.model.Customer
import org.springframework.stereotype.Component

@Component
class CustomerViewMapper : Mapper<Customer, CustomerView> {

    override fun map(t: Customer): CustomerView {
        return CustomerView(
            id = t.id,
            name = t.name,
            email = t.email,
            createdAt = t.createdAt,
            //TODO: DEIXAR SERIALIZAR SOMENTE DURANTE OS TESTES
            roles = t.roles
        )
    }
}