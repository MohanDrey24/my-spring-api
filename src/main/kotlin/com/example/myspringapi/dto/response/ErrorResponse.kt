package com.example.myspringapi.dto.response

import org.springframework.http.HttpStatus

data class ErrorResponse(
    val status: HttpStatus,
    val message: String?,
)
