package br.com.architectbudgeplanner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ArchitectBudgePlannerApplication

fun main(args: Array<String>) {
	runApplication<ArchitectBudgePlannerApplication>(*args)
}
