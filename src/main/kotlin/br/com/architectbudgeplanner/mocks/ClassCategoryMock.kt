package br.com.architectbudgeplanner.mocks

import br.com.architectbudgeplanner.model.ClassCategory
import java.util.*

fun getClassesMock(): List<ClassCategory> {

    val c1 = ClassCategory(id = 1, description = "MATERIAL", acronym = "MAT")
    val c2 = ClassCategory(id = 2, description = "MÃO DE OBRA", acronym = "MO")
    val c3 = ClassCategory(id = 3, description = "SERVIÇOS TÉCNICOS", acronym = "STEC")
    val c4 = ClassCategory(id = 4, description = "SERVIÇOS ESPECIALIZADOS", acronym = "SESPEC")

    return Arrays.asList(c1, c2, c3, c4)
}