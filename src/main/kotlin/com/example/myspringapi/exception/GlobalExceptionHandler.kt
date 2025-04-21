package com.example.myspringapi.exception

import com.example.myspringapi.dto.response.*
import org.springframework.http.*
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.*

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        val error =
            ErrorResponse(
                status = HttpStatus.BAD_REQUEST,
                message = ex.message,
            )

        return ResponseEntity.badRequest().body(error)
    }
}
