package com.example.geospringdata.controller

import com.example.geospringdata.model.Country
import com.example.geospringdata.sevice.ContryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/countries")
class CountryController(
    private val countryService: ContryService,
) {

    @GetMapping
    fun getAll(): List<Country> = countryService.getAll()
}