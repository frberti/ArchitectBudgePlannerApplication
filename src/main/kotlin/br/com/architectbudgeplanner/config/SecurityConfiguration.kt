package br.com.architectbudgeplanner.config

import br.com.architectbudgeplanner.security.JWTLoginFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    val jwtUtil: JWTUtil
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity, config: AuthenticationConfiguration): SecurityFilterChain {
        http.csrf {
            it.disable()
        }
            .authorizeHttpRequests {
                it.requestMatchers(HttpMethod.POST, "/login").permitAll()
                    .anyRequest().authenticated()
            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .headers {
                it.frameOptions{it.disable()}
            }
            .addFilterBefore(JWTLoginFilter(authManager = config.authenticationManager, jwtUtil = jwtUtil), UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder()

}
