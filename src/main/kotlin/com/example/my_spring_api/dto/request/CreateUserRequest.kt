package com.example.my_spring_api.dto.request

data class CreateUserRequest(
    val email: String,
    val password: String
)
