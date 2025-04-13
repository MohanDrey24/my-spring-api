package com.example.my_spring_api.repository

import com.example.my_spring_api.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository: JpaRepository<User, UUID> {
    fun findByEmail(email: String): User?
}