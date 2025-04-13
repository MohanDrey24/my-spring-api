package com.example.my_spring_api.service

import com.example.my_spring_api.dto.request.CreateUserRequest
import com.example.my_spring_api.entity.*
import com.example.my_spring_api.repository.AccountRepository
import com.example.my_spring_api.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
    private val userRepository: UserRepository,
    private val accountRepository: AccountRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    fun createUser(request: CreateUserRequest) {
        val existingUser = userRepository.findByEmail(request.email)

        if (existingUser != null) {
            throw ResponseStatusException(
                HttpStatus.CONFLICT,
                "User with email ${request.email} already exists"
            )
        }

        val newUser = User(email = request.email)
        userRepository.save(newUser)

        val password = passwordEncoder.encode(request.password)
        val newAccount = Account(hash = password, user = newUser)
        accountRepository.save(newAccount)
    }
}