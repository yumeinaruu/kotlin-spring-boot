package org.yumeinaruu.kotlin_project.service

import org.springframework.stereotype.Service
import org.yumeinaruu.kotlin_project.exception.custom.NoSuchDataInDbException
import org.yumeinaruu.kotlin_project.model.Link
import org.yumeinaruu.kotlin_project.model.dto.LinkCreateDto
import org.yumeinaruu.kotlin_project.model.dto.LinkUpdateDto
import org.yumeinaruu.kotlin_project.repository.LinkRepository
import org.yumeinaruu.kotlin_project.repository.UserRepository
import java.util.Optional

@Service
class LinkService(val linkRepository: LinkRepository, val userRepository: UserRepository) {
    fun getAllLinks() = linkRepository.findAll()

    fun getLinkById(id: Long?): Optional<Link> {
        return linkRepository.findById(id ?: return Optional.empty())
    }

    fun createLink(linkCreateDto: LinkCreateDto): Boolean {
        val link = Link()
        link.setService(linkCreateDto.getService())
        link.setLink(linkCreateDto.getLink())
        if(userRepository.findByUsername(linkCreateDto.getUsername() ?: return false).isPresent) {
            link.setUser(userRepository.findByUsername(linkCreateDto.getUsername() ?: return false).get())
        } else {
            throw NoSuchDataInDbException()
        }
        val savedLink = linkRepository.save(link)
        return getLinkById(savedLink.getId()).isPresent
    }

    fun updateLink(linkUpdateDto: LinkUpdateDto): Boolean {
        val optionalLink = linkRepository.findById(linkUpdateDto.getId() ?: return false)
        if(optionalLink.isPresent) {
            val link = optionalLink.get()
            link.setService(linkUpdateDto.getService())
            link.setLink(linkUpdateDto.getLink())
            if(userRepository.findByUsername(linkUpdateDto.getUsername() ?: return false).isPresent) {
                link.setUser(userRepository.findByUsername(linkUpdateDto.getUsername() ?: return false).get())
            } else {
                throw NoSuchDataInDbException()
            }
            val savedLink = linkRepository.saveAndFlush(link)
            return savedLink == link
        }
        return false
    }

    fun deleteLink(id: Long?): Boolean {
        val optionalLink = linkRepository.findById(id ?: return false)
        if(optionalLink.isPresent) {
            linkRepository.delete(optionalLink.get())
            return true
        }
        return false
    }
}