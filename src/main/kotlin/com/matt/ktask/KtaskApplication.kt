package com.matt.ktask

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtaskApplication

fun main(args: Array<String>) {
	runApplication<KtaskApplication>(*args)
}
