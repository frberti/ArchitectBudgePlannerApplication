package br.com.architectbudgeplanner.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@Component
data class JWTUtil(
    private val expiration: Long = 60000
) {
    @Value("\${jwt.secret}")
    private var secret: String = "secret"
    private val key = Algorithm.HMAC256(secret.toByteArray())

    fun generateToken(username: String): String? {
        return JWT.create()
            .withSubject(username)
            .withExpiresAt(Date(System.currentTimeMillis() + expiration))
            .sign(key)
    }

    fun isValid(jwt: String?): Boolean {
        return try {
            JWT.require(key)
                .build()
                .verify(jwt)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAuthentication(jwt: String?): Authentication {
        val username = JWT.require(key)
            .build()
            .verify(jwt)
            .subject

        return UsernamePasswordAuthenticationToken(username, null, null)
    }

}
