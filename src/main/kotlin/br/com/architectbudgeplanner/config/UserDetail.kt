package br.com.architectbudgeplanner.config

import br.com.architectbudgeplanner.model.Costumer
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(
    private val costumer: Costumer
)  : UserDetails{
    override fun getAuthorities() = null

    override fun getPassword() = costumer.password

    override fun getUsername() = costumer.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}