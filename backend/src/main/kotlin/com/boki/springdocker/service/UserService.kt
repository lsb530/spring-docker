package com.boki.springdocker.service

import com.boki.springdocker.dto.CreateUserReq
import com.boki.springdocker.dto.UserResponse
import com.boki.springdocker.model.UserEntity
import com.boki.springdocker.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class UserService(
    private val userRepository: UserRepository,
) {
    @Transactional
    fun createUser(createUserReq: CreateUserReq): UserResponse {
        val userEntity = UserEntity(
            username = createUserReq.username,
            password = createUserReq.password
        )
        val savedUserEntity = userRepository.save(userEntity)

        return UserResponse(
            id = savedUserEntity.id,
            username = savedUserEntity.username,
            password = savedUserEntity.password
        )
    }

    fun findUser(id: Long): UserResponse {
        val userEntity = userRepository.findByIdOrNull(id)
            ?: throw RuntimeException("User Not Found")

        return UserResponse(
            id = userEntity.id,
            username = userEntity.username,
            password = userEntity.password
        )
    }

    fun findUsers(): List<UserResponse> {
        return userRepository.findAll().map {
            UserResponse(
                id = it.id,
                username = it.username,
                password = it.password
            )
        }
    }
}