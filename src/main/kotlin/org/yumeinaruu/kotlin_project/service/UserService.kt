package org.yumeinaruu.kotlin_project.service

import org.springframework.stereotype.Service
import org.yumeinaruu.kotlin_project.model.User
import org.yumeinaruu.kotlin_project.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {
    fun findAll(): List<User> = userRepository.findAll()

    fun createUser(user: User): User = userRepository.save(user)
}