package com.sinelnikov.dockerexample

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tag
import io.micrometer.core.instrument.Timer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit
import kotlin.random.Random


@RestController
@RequestMapping("health")
class HealthController(
    private val registry: MeterRegistry
) {
    val timer = Timer
        .builder("test.timer")
        .publishPercentiles(0.5, 0.75, 0.95)
        .tags(listOf(Tag.of("method", "method1")))
        .register(registry)

    val timer1 = Timer
        .builder("lolz")
        .publishPercentiles(0.5, 0.75, 0.95)
        .tags(listOf(Tag.of("method", "method2")))
        .register(registry)


    @GetMapping
    fun getHealth(): Status {
        return Status("OK")
    }

    @GetMapping("method1")
    fun getMethod1(): String {
        val nextLong = Random.nextLong(8, 15)
        timer.record(nextLong, TimeUnit.SECONDS)
        return nextLong.toString()
    }

    @GetMapping("method2")
    fun getMethod2(): String {
        val nextLong = Random.nextLong(8, 15)
        timer1.record(nextLong, TimeUnit.SECONDS)
        return nextLong.toString()
    }
}

data class Status(
    val status: String,
)