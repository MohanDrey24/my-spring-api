package com.example.my_spring_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("com.example.my_spring_api.entity")
class MySpringApiApplication

fun main(args: Array<String>) {
	runApplication<MySpringApiApplication>(*args)
}
