package br.com.architectbudgeplanner.config

import br.com.architectbudgeplanner.config.RolesPermissions.Companion.READ
import br.com.architectbudgeplanner.config.RolesPermissions.Companion.WRITE
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            csrf { disable() }
            authorizeRequests {

                authorize(HttpMethod.POST,"/item-composition", hasAuthority(WRITE))
                authorize(HttpMethod.PUT,"/item-composition", hasAuthority(WRITE))
                authorize(HttpMethod.DELETE,"/item-composition", hasAuthority(WRITE))

                authorize(HttpMethod.POST,"/classes", hasAuthority(WRITE))
                authorize(HttpMethod.PUT,"/classes", hasAuthority(WRITE))
                authorize(HttpMethod.DELETE,"/classes", hasAuthority(WRITE))

                authorize(HttpMethod.POST,"/categories", hasAuthority(WRITE))
                authorize(HttpMethod.PUT,"/categories", hasAuthority(WRITE))
                authorize(HttpMethod.DELETE,"/categories", hasAuthority(WRITE))

                authorize(HttpMethod.POST,"/customers", hasAuthority(WRITE))

                authorize(anyRequest, authenticated)
            }
            sessionManagement {
                sessionCreationPolicy = SessionCreationPolicy.STATELESS
            }
            headers { frameOptions { disable() } }
            httpBasic { }
        }
        return http.build()
    }

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder()

}