package com.boki.springdocker.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @GetMapping("/api")
    fun home(): String {
        return "Boki's Docker Springboot adf Test!!!"
    }

    @GetMapping("/cors")
    fun home2(): String {
        return "CORS Test"
    }
}