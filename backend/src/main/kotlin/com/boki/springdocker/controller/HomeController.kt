package com.boki.springdocker.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @GetMapping("/")
    fun home(): String {
        return "KK's Docker Springboot adf Test!!!"
    }

//    @GetMapping("/test")
//    fun test(): String {
//        return "Test!!!"
//    }
}