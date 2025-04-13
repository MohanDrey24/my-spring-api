package com.example.my_spring_api.dto.response

import java.util.UUID

data class CreateUserResponse(
    val message: String,
    val userId: UUID?
)
