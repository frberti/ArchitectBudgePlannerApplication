package br.com.architectbudgeplanner.mocks

import br.com.architectbudgeplanner.model.CategorizedItemComposition
import br.com.architectbudgeplanner.model.Category
import br.com.architectbudgeplanner.model.ClassCategory
import java.util.*

fun getItemsCategoryMock(): List<Category> {
    val comp1 = CategorizedItemComposition(id = 1, description = "Pedra britada 4", acronym ="PEBR",
        classCategory = ClassCategory(id = 1, description = "MATERIAL", acronym ="MAT"), null)

    val comp11 = CategorizedItemComposition(id = 1, description = "Chapa compensada plastificada (comprimento: 2200 mm / espessura: 12 mm / largura: 1100 mm)", acronym ="CHAP",
        classCategory = ClassCategory(id = 1, description = "MATERIAL", acronym ="MAT"), null)

    val comp2 = CategorizedItemComposition(id = 1, description = "Carpinteiro", acronym ="CARP",
        classCategory = ClassCategory(id = 1, description = "MÃO DE OBRA", acronym ="MO"), null)

    val comp22 = CategorizedItemComposition(id = 1, description = "Pedreiro", acronym ="PEDR",
        classCategory = ClassCategory(id = 1, description = "MÃO DE OBRA", acronym ="MO"), null)

    val comp3 = CategorizedItemComposition(id = 1, description = "Serviços de Serralheria", acronym ="SERR",
        classCategory = ClassCategory(id = 1, description = "SERVIÇOS ESPECIALIZADOS", acronym ="SE"), null)

    val comp33 = CategorizedItemComposition(id = 1, description = "Serviços de acabamento em pisos", acronym ="SERPIS",
        classCategory = ClassCategory(id = 1, description = "SERVIÇOS ESPECIALIZADOS", acronym ="SE"), null)

    val c1 = Category(id = 3, description = "ESTRUTURAIS", acronym ="ESTR", categorizedItens = Arrays.asList(comp1, comp11))
    val c2 = Category(id = 4, description = "ALVENARIA", acronym ="ALVE", categorizedItens = Arrays.asList(comp2, comp22))
    val c3 = Category(id = 5, description = "PISOS/ REVESTIMENTOS/ CONCRETAGENS", acronym ="PRC", categorizedItens = Arrays.asList(comp33))
    val c4 = Category(id = 2, description = "BASICOS", acronym ="BASI", categorizedItens = Arrays.asList(comp3))

    return Arrays.asList(c1, c2, c3, c4)
}

fun getCategoriesMock(): List<Category> {
    val c1 = Category(id = 1, description = "INSTALAÇÃO E INFRA DO CANTEIRO", acronym ="CANT", null)
    val c2 = Category(id = 2, description = "BASICOS", acronym ="BASI", null)
    val c3 = Category(id = 3, description = "ESTRUTURAIS", acronym ="ESTR", null)
    val c4 = Category(id = 4, description = "ALVENARIAS", acronym ="ALVE", null)
    val c5 = Category(id = 5, description = "PISOS/ REVESTIMENTOS/ CONCRETAGENS", acronym ="PRC", null)
    val c6 = Category(id = 6, description = "PINTURA", acronym ="PINT", null)
    val c7 = Category(id = 7, description = "COBERTURA", acronym ="COBE", null)
    val c8 = Category(id = 8, description = "IMPERMEABILIZAÇOES", acronym ="IMPE", null)
    val c9 = Category(id = 9, description = "HIDROSANITÁRIOS", acronym ="HIDS", null)
    val c10 = Category(id = 10, description = "ELÉTRICA", acronym ="ELET", null)
    val c11 = Category(id = 11, description = "ESQUADRIAS", acronym ="ESQU", null)
    val c12 = Category(id = 12, description = "DIVERSOS", acronym ="DIVE", null)

    return Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12)
}