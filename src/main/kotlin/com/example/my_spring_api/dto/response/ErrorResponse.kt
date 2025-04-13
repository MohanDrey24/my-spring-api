package com.example.my_spring_api.dto.response

import org.springframework.http.HttpStatus

data class ErrorResponse(
    val status: HttpStatus,
    val message: String?
)
