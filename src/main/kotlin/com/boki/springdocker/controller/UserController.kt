package com.boki.springdocker.controller

import com.boki.springdocker.dto.CreateUserReq
import com.boki.springdocker.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/users")
@RestController
class UserController(
    private val userService: UserService,
) {
    @GetMapping
    fun findUsers(): ResponseEntity<Any> {
        return ResponseEntity.ok().body(userService.findUsers())
    }

    @GetMapping("/{id}")
    fun fundUser(
        @PathVariable id: Long,
    ): ResponseEntity<Any> {
        return ResponseEntity.ok().body(userService.findUser(id))
    }

    @PostMapping
    fun createUser(
        @RequestBody createUserReq: CreateUserReq
    ): ResponseEntity<Any> {
        return ResponseEntity.ok().body(userService.createUser(createUserReq))
    }
}