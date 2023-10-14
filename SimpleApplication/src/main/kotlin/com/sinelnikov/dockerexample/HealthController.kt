package com.sinelnikov.dockerexample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("health")
class HealthController(
) {

    @GetMapping
    fun getHealth(): Status {
        return Status("OK")
    }
}

data class Status(
    val status: String,
)