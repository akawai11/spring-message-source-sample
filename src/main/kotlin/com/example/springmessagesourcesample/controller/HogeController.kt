package com.example.springmessagesourcesample.controller

import com.example.springmessagesourcesample.exception.DataNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("hoge")
class HogeController {

    @Autowired
    lateinit var messageSource: MessageSource

    @GetMapping("message")
    fun getMessage(locale: Locale): ResponseEntity<String> {
        val errorMsg = messageSource.getMessage("hoge", null, locale)
        return ResponseEntity.ok(errorMsg)
    }

    @GetMapping("exception")
    fun getException(): ResponseEntity<String> {
        // コンパイルを通すためにif分を挟む
        if (true) {
            throw DataNotFoundException()
        }
        return ResponseEntity.ok("")
    }
}