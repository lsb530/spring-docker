package com.boki.springdocker.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @PostMapping("/auth")
    fun auth(
            @RequestBody authReq: AuthReq?
    ): ResponseEntity<Any> {
        val authRes = AuthRes(
                email = authReq?.email,
                password = authReq?.password,
        )
        val mockJWT = if (authReq?.email != null && authReq.password != null) {
            """
            eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
            eyJzdWIiOiIxMjM0NTY3ODkwIiwibnFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.
            SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
        """.trimIndent().replace("\n", "")
        } else {
            null
        }
        authRes.accessToken = mockJWT

        val headers = HttpHeaders()
        mockJWT?.let {
            headers.add("accessToken", it)
        }

        return ResponseEntity.ok().headers(headers).body(authRes)
    }

    @GetMapping("/test")
    fun test(@RequestHeader(value = "Access-Token") accessToken: String?): String {
        return accessToken?.let { "OK" }
                ?: throw RuntimeException("Access token is missing!")
    }

    @GetMapping("/test1")
    fun test1(@RequestHeader(value = "Access-Token") accessToken: String?): String {
        return accessToken?.let { "OK" }
                ?: throw RuntimeException("Access token is missing!")
    }

    @GetMapping("/test2")
    fun test2(@RequestHeader(value = "Access-Token") accessToken: String?): String {
        return accessToken?.let { "OK" }
                ?: throw RuntimeException("Access token is missing!")
    }

    @GetMapping("/test3")
    fun test3(@RequestHeader(value = "Access-Token") accessToken: String?): String {
        return accessToken?.let { "OK" }
                ?: throw RuntimeException("Access token is missing!")
    }
}

data class AuthReq(
        val email: String?,
        val password: String?,
)

data class AuthRes(
        val email: String?,
        val password: String?,
        var accessToken: String? = null,
)