package org.yumeinaruu.kotlin_project.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.yumeinaruu.kotlin_project.model.User
import org.yumeinaruu.kotlin_project.model.dto.UserCreateDto
import org.yumeinaruu.kotlin_project.service.UserService

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {
    @GetMapping
    fun getUsers(): List<User> {
        return userService.findAll()
    }

    @PostMapping
    fun create(@RequestBody user: UserCreateDto): ResponseEntity<User> {
        if(userService.createUser(user)){
            return ResponseEntity(HttpStatus.CREATED)
        }
        return ResponseEntity(HttpStatus.CONFLICT)
    }
}