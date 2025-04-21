package com.example.myspringapi.controller

import com.example.myspringapi.dto.request.CreateUserRequest
import com.example.myspringapi.dto.response.CreateUserResponse
import com.example.myspringapi.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/signup")
    fun signUp(
        @Valid @RequestBody request: CreateUserRequest,
    ): ResponseEntity<CreateUserResponse> {
        val newAccount = userService.createUser(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(
            CreateUserResponse(
                message = "User created successfully",
                userId = newAccount.user?.id,
            ),
        )
    }
}
