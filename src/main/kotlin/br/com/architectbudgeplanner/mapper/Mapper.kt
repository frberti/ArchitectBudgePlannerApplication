package br.com.architectbudgeplanner.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}