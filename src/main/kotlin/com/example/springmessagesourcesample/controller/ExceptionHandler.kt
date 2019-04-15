package com.example.springmessagesourcesample.controller

import com.example.springmessagesourcesample.exception.DataNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*

@RestControllerAdvice
class ExceptionHandler {

    @Autowired
    lateinit var messageSource: MessageSource

    @ExceptionHandler(DataNotFoundException::class)
    fun handleDataNotFoundException(e: DataNotFoundException, locale: Locale): ResponseEntity<String> {
        val errorMsg = messageSource.getMessage("dataNotFound", null, locale)
        return ResponseEntity(errorMsg, HttpStatus.NOT_FOUND)
    }

}