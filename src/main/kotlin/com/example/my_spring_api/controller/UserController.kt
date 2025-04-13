package com.example.my_spring_api.controller

import com.example.my_spring_api.dto.request.CreateUserRequest
import com.example.my_spring_api.dto.response.CreateUserResponse
import com.example.my_spring_api.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class UserController (
    private val userService: UserService
) {

    @GetMapping("/sample")
    fun sample(): String {
        return "Hello world motherfucker"
    }

    @PostMapping("/signup")
    fun signUp(@RequestBody request: CreateUserRequest): ResponseEntity<Any> {
        return try {
            val user = userService.createUser(request)

            ResponseEntity.status(HttpStatus.CREATED).body(
                CreateUserResponse(
                    message = "User created successfully",
                    userId = null,
                )
            )
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

}