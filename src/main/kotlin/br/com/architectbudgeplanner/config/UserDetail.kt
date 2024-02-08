package br.com.architectbudgeplanner.config

import br.com.architectbudgeplanner.model.Customer
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(
    private val customer: Customer
)  : UserDetails{
    override fun getAuthorities() = customer.roles

    override fun getPassword() = customer.password

    override fun getUsername() = customer.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}