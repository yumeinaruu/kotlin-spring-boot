package org.yumeinaruu.kotlin_project.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.yumeinaruu.kotlin_project.model.Link
import org.yumeinaruu.kotlin_project.model.dto.LinkCreateDto
import org.yumeinaruu.kotlin_project.model.dto.LinkUpdateDto
import org.yumeinaruu.kotlin_project.service.LinkService

@RestController
@RequestMapping("/link")
class LinkController(val linkService: LinkService) {
    @GetMapping
    fun getLinks(): ResponseEntity<List<Link>> {
        val links = linkService.getAllLinks()
        if(links.isEmpty()){
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(links, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getLinkById(@PathVariable("id") id: Long): ResponseEntity<Link> {
        val optionalLink = linkService.getLinkById(id)
        if(optionalLink.isPresent){
            return ResponseEntity(optionalLink.get(), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping
    fun create(@RequestBody link: LinkCreateDto): ResponseEntity<HttpStatus> {
        if(linkService.createLink(link)) {
            return ResponseEntity(HttpStatus.CREATED)
        }
        return ResponseEntity(HttpStatus.CONFLICT)
    }

    @PutMapping
    fun update(@RequestBody link: LinkUpdateDto): ResponseEntity<HttpStatus> {
        if(linkService.updateLink(link)) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(HttpStatus.CONFLICT)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<HttpStatus> {
        if(linkService.deleteLink(id)) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(HttpStatus.OK)
    }
}