package org.yumeinaruu.kotlin_project.model.dto

import org.springframework.stereotype.Component

@Component
class LinkUpdateDto {
    private var id: Long? = null
    private var service: String? = null
    private var link: String? = null
    private var username: String? = null

    fun setId(id: Long?) {
        this.id = id
    }

    fun getId(): Long? {
        return id
    }

    fun setService(service: String?) {
        this.service = service
    }

    fun setLink(link: String?) {
        this.link = link
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    fun getService(): String? {
        return service
    }

    fun getLink(): String? {
        return link
    }

    fun getUsername(): String? {
        return username
    }
}