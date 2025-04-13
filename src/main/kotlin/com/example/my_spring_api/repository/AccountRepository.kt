package com.example.my_spring_api.repository

import com.example.my_spring_api.entity.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AccountRepository: JpaRepository<Account, AccountId> {
    fun findByUserId(userId: UUID): List<Account>
}