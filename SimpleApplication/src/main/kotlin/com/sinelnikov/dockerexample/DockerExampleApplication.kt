package com.sinelnikov.dockerexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DockerExampleApplication

fun main(args: Array<String>) {
    runApplication<DockerExampleApplication>(*args)
}
