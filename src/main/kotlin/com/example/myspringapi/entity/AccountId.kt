package com.example.myspringapi.entity

import java.io.Serializable
import java.util.UUID

data class AccountId(
    val provider: String = "password",
    val user: UUID? = null,
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
