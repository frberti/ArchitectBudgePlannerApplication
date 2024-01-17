package br.com.architectbudgeplanner.utils

interface Utils<T, U> {

    fun updateList(form: T, list: MutableList<U>) : U?

}