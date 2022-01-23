package com.example.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class CountryNotFoundException(val id: Int): BaseException(
    HttpStatus.NOT_FOUND,
    "county.not.found",
    "contry with id=$id not found"
)