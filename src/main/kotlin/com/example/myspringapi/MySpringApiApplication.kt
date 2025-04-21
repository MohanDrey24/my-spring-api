package com.example.myspringapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("com.example.myspringapi.entity")
class MySpringApiApplication

@SuppressWarnings("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<MySpringApiApplication>(*args)
}
