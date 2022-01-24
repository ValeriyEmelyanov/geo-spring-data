package com.example.geospringdata.exception

import org.springframework.http.HttpStatus

class CountryNotFoundException(val id: Int): BaseException(
    HttpStatus.NOT_FOUND,
    "county.not.found",
    "contry with id=$id not found"
)