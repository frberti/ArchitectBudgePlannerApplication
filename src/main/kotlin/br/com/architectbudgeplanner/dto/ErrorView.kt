package br.com.architectbudgeplanner.dto

import java.time.LocalDateTime

data class ErrorView (

    private val timeStamp: LocalDateTime = LocalDateTime.now(),
    private val status: Int,
    private val error: String,
    private val message: String?,
    private val path: String

)
