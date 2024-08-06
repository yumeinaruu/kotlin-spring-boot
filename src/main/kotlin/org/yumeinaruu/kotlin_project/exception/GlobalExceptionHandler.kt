package org.yumeinaruu.kotlin_project.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.yumeinaruu.kotlin_project.exception.custom.NoSuchDataInDbException

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchDataInDbException::class)
    fun handleException(e: NoSuchDataInDbException): ResponseEntity<HttpStatus> {
        println(e.message)
        return ResponseEntity(HttpStatus.CONFLICT)
    }
}