package com.example.myspringapi.dto.request

import jakarta.validation.constraints.NotBlank

data class CreateUserRequest(
    @field:NotBlank(message = "email is required mofo")
    val email: String,
    val password: String,
)
