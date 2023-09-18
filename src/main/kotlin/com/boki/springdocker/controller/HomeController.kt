package com.boki.springdocker.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HomeController {
    @RequestMapping("/")
    fun sample(): String {
        return "Docker Springboot Test"
    }
}