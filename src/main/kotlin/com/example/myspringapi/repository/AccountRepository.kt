package com.example.myspringapi.repository

import com.example.myspringapi.entity.Account
import com.example.myspringapi.entity.AccountId
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AccountRepository : JpaRepository<Account, AccountId> {
    fun findByUserId(userId: UUID): List<Account>
}
