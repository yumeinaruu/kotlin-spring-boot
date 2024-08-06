package org.yumeinaruu.kotlin_project.model.dto

import org.springframework.stereotype.Component

@Component
class UserUpdateDto {
    private var id: Long? = null
    private var username: String? = null
    private var description: String? = null

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }
}