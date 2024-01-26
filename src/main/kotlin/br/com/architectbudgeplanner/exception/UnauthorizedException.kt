package br.com.architectbudgeplanner.exception

import java.lang.RuntimeException

class UnauthorizedException (message: String?) : RuntimeException(message)