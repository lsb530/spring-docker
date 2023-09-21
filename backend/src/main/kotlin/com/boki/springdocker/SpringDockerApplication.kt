package com.boki.springdocker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringDockerApplication

fun main(args: Array<String>) {
    runApplication<SpringDockerApplication>(*args)
}
