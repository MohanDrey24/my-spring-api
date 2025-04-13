package com.example.my_spring_api.entity

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "accounts")
@IdClass(AccountId::class)
class Account(
    @Id
    @Column(nullable = false)
    val provider: String = "password",

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User? = null,

    @Column(nullable = false)
    val hash: String = "",

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: Instant = Instant.now(),

    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant = Instant.now()
)
