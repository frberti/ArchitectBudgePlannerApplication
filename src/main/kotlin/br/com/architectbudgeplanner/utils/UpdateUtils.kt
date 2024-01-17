package br.com.architectbudgeplanner.utils

interface UpdateUtils<T, U> {

    fun updateList(form: T, list: MutableList<U>) : U?

}