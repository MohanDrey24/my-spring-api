package com.example.myspringapi

import com.example.myspringapi.dto.request.CreateUserRequest
import com.example.myspringapi.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertEquals

class AuthServiceTest: DatabaseTestContainer() {
    @Autowired
    lateinit var userService: UserService

    @Test
    fun `should sign up and fetch a user`() {
        val request = CreateUserRequest("mohandrey69@yahoo.com", "1234")
        userService.createUser(request)

        val users = userService.getAllUser()
        assertEquals(1, users.size)
        assertEquals("mohandrey69@yahoo.com", users[0].email)
    }
}
