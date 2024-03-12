package br.com.architectbudgeplanner.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import java.util.*

data class JWTUtil(
    private val expiration: Long = 60000
) {
    @Value("\${jwt.secret}")
    private lateinit var secret: String
    private val key = Keys.hmacShaKeyFor(secret.toByteArray())

    fun generateToken(username: String): String? {
        return Jwts.builder()
            .subject(username)
            .expiration(Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact()
    }

    fun isValid(jwt: String?): Boolean {
        return try {
            Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAuthentication(jwt: String?): Authentication {
        val username = Jwts.parser()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(jwt)
            .body
            .subject

        return UsernamePasswordAuthenticationToken(username, null, null)
    }

}