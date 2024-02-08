package br.com.architectbudgeplanner.repository

import br.com.architectbudgeplanner.model.Customer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CustomerRepository : JpaRepository<Customer, Long> {


    fun findByEmail(username: String?): Customer?

    @Query(
        "SELECT c " +
                "FROM Customer c " +
                "WHERE " +
                "(:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
                "AND " +
                "(:email IS NULL OR LOWER(c.email) LIKE LOWER(CONCAT('%', :email, '%')))"
    )
    fun findByParams(
        @Param("name") name: String?,
        @Param("email") email: String?,
        pageable: Pageable
    ): Page<Customer>


}