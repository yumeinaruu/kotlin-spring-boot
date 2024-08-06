package org.yumeinaruu.kotlin_project.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.yumeinaruu.kotlin_project.model.User
import org.yumeinaruu.kotlin_project.model.dto.UserCreateDto
import org.yumeinaruu.kotlin_project.model.dto.UserUpdateDto
import org.yumeinaruu.kotlin_project.service.UserService

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {
    @GetMapping
    fun getUsers(): ResponseEntity<List<User>> {
        val users: List<User> = userService.findAll()
        if (users.isEmpty()) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(users, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val optionalUser: java.util.Optional<User> = userService.findUserById(id)
        if (optionalUser.isPresent) {
            return ResponseEntity(optionalUser.get(), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping
    fun create(@RequestBody user: UserCreateDto): ResponseEntity<HttpStatus> {
        if (userService.createUser(user)) {
            return ResponseEntity(HttpStatus.CREATED)
        }
        return ResponseEntity(HttpStatus.CONFLICT)
    }

    @PutMapping
    fun update(@RequestBody user: UserUpdateDto): ResponseEntity<HttpStatus> {
        if (userService.updateUser(user)) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(HttpStatus.CONFLICT)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<HttpStatus> {
        if (userService.deleteUserById(id)) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(HttpStatus.CONFLICT)
    }
}