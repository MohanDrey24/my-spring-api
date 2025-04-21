package com.example.myspringapi.service

import com.example.myspringapi.dto.request.CreateUserRequest
import com.example.myspringapi.entity.*
import com.example.myspringapi.repository.*
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
    private val userRepository: UserRepository,
    private val accountRepository: AccountRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    @Transactional
    fun createUser(request: CreateUserRequest): Account {
        userRepository.findByEmail(request.email)?.let {
            throw ResponseStatusException(
                HttpStatus.CONFLICT,
                "User with email ${request.email} already exists",
            )
        }

        val newUser = User(email = request.email)
        userRepository.save(newUser)

        val password = passwordEncoder.encode(request.password)
        val newAccount = Account(hash = password, user = newUser)
        accountRepository.save(newAccount)

        return newAccount
    }
}
