package org.yumeinaruu.kotlin_project.controller

import org.springframework.web.bind.annotation.*
import org.yumeinaruu.kotlin_project.model.User
import org.yumeinaruu.kotlin_project.service.UserService

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {
    @GetMapping
    fun getUsers(): List<User> {
        return userService.findAll()
    }

    @PostMapping
    fun create(@RequestBody user: User): User {
        userService.createUser(user)
        return user
    }
}