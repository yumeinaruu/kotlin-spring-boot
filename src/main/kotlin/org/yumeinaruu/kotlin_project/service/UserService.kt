package org.yumeinaruu.kotlin_project.service

import org.springframework.stereotype.Service
import org.yumeinaruu.kotlin_project.model.User
import org.yumeinaruu.kotlin_project.model.dto.UserCreateDto
import org.yumeinaruu.kotlin_project.model.dto.UserUpdateDto
import org.yumeinaruu.kotlin_project.repository.UserRepository
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    fun findAll(): List<User> = userRepository.findAll()

    fun findUserById(id: Long?): Optional<User> {
        return userRepository.findById(id ?: return Optional.empty())
    }

    fun createUser(userCreateDto: UserCreateDto): Boolean {
        val user: User = User()
        user.setUsername(userCreateDto.getUsername())
        user.setDescription(userCreateDto.getDescription())
        user.setCreated(Timestamp.valueOf(LocalDateTime.now()))
        user.setChanged(Timestamp.valueOf(LocalDateTime.now()))
        val savedUser = userRepository.save(user)
        return findUserById(savedUser.getId()).isPresent
    }

    fun updateUser(userUpdateDto: UserUpdateDto): Boolean {
        val userOptional: Optional<User> = userRepository.findById(userUpdateDto.getId() ?: return false)
        if (userOptional.isPresent) {
            val user = userOptional.get()
            user.setUsername(userUpdateDto.getUsername())
            user.setDescription(userUpdateDto.getDescription())
            user.setChanged(Timestamp.valueOf(LocalDateTime.now()))
            val savedUser = userRepository.saveAndFlush(user)
            return savedUser == user
        }
        return false
    }

    fun deleteUserById(id: Long?): Boolean {
        val userOptional: Optional<User> = userRepository.findById(id ?: return false)
        if (userOptional.isPresent) {
            userRepository.delete(userOptional.get())
            return true
        }
        return false
    }
}