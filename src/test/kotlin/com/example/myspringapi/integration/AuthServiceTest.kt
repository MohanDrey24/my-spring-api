package com.example.myspringapi

import com.example.myspringapi.dto.request.CreateUserRequest
import com.example.myspringapi.service.UserService
import junit.framework.TestCase.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AuthServiceTest: DatabaseTestContainer() {
    @Autowired
    lateinit var userService: UserService

    @Test
    @DisplayName("Should sign up and fetch a user")
    fun signUp() {
        val request = CreateUserRequest("mohandrey69@yahoo.com", "1234")
        userService.createUser(request)

        val users = userService.getAllUser()
        assertNotNull(users)
        assertEquals(1, users.size)
        assertEquals("mohandrey69@yahoo.com", users[0].email)
    }
}
