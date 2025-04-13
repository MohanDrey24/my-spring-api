package com.example.my_spring_api.entity

import java.io.Serializable
import java.util.UUID

data class AccountId(
    val provider: String = "password",
    val user: UUID? = null
): Serializable
