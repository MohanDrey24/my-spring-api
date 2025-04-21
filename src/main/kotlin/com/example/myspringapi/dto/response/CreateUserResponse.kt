package com.example.myspringapi.dto.response

import java.util.UUID

data class CreateUserResponse(
    val message: String,
    val userId: UUID?,
)
