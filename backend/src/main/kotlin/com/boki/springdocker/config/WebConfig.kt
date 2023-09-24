package com.boki.springdocker.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    @Value("\${spring.profiles.active:}")
    private lateinit var activeProfile: String

    private val allowedOrigins = mutableListOf("http://localhost:5200")
//    private val allowedOrigins = mutableListOf("http://localhost:5173")
    override fun addCorsMappings(registry: CorsRegistry) {
        println("activeProfile = ${activeProfile}")

        if (activeProfile == "local" || activeProfile == "dev") {
//            allowedOrigins.add("*")
        }

        registry.addMapping("/**")
                .allowedOrigins(*allowedOrigins.toTypedArray())
                .allowedMethods(
                        HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.PATCH.name(),
                        HttpMethod.DELETE.name()
                )
    }

}