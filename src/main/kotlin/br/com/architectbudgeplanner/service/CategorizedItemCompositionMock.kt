package br.com.architectbudgeplanner.service

import br.com.architectbudgeplanner.model.CategorizedItemComposition
import br.com.architectbudgeplanner.model.Category
import br.com.architectbudgeplanner.model.ClassCategory
import java.util.*

fun getItensMock(): List<CategorizedItemComposition> {

    val comp1 = CategorizedItemComposition(id = 1, description = "Pedra britada 4", acronym ="PEBR",
        classCategory = ClassCategory(id = 1, description = "MATERIAL", acronym ="MAT"),
        category = Category(id = 1, description = "ESTRUTURAIS", acronym ="ESTR", null)
    )

    val comp2 = CategorizedItemComposition(id = 2, description = "Chapa compensada plastificada (comprimento: 2200 mm / espessura: 12 mm / largura: 1100 mm)", acronym ="CHAP",
        classCategory = ClassCategory(id = 1, description = "MATERIAL", acronym ="MAT"),
        category = Category(id = 1, description = "ESTRUTURAIS", acronym ="ESTR", null)
    )

    val comp3 = CategorizedItemComposition(id = 3, description = "Carpinteiro", acronym ="CARP",
        classCategory = ClassCategory(id = 2, description = "MÃO DE OBRA", acronym ="MO"),
        category = Category(id = 1, description = "ALVENARIA", acronym ="ALVE", categorizedItens = null)
    )

    val comp4 = CategorizedItemComposition(id = 4, description = "Pedreiro", acronym ="PEDR",
        classCategory = ClassCategory(id = 2, description = "MÃO DE OBRA", acronym ="MO"),
        category = Category(id = 1, description = "ALVENARIA", acronym ="ALVE", categorizedItens = null)
    )

    val comp5 = CategorizedItemComposition(id = 5, description = "Serviços de Serralheria", acronym ="SERR",
        classCategory = ClassCategory(id = 4, description = "SERVIÇOS ESPECIALIZADOS", acronym ="SE"),
        category = Category(id = 2, description = "BASICOS", acronym ="BASI", categorizedItens = null)
    )

    val comp6 = CategorizedItemComposition(id = 6, description = "Serviços de acabamento em pisos", acronym ="SERPIS",
        classCategory = ClassCategory(id = 4, description = "SERVIÇOS ESPECIALIZADOS", acronym ="SE"),
        category = Category(id = 1, description = "PISOS/ REVESTIMENTOS/ CONCRETAGENS", acronym ="PRC", categorizedItens = null)
    )

    return Arrays.asList(comp1, comp2, comp3, comp4, comp5, comp6)
}