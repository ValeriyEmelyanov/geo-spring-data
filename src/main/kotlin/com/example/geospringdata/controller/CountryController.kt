package com.example.geospringdata.controller

import com.example.geospringdata.dto.CountryDto
import com.example.geospringdata.sevice.ContryService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/countries")
class CountryController(
    private val countryService: ContryService,
) {

    @GetMapping
    fun getAll(): List<CountryDto> = countryService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): CountryDto = countryService.getById(id)

    @PostMapping
    fun create(@RequestBody countryDto: CountryDto): CountryDto = countryService.create(countryDto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody countryDto: CountryDto): CountryDto =
        countryService.update(id, countryDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        countryService.deleteById(id)
    }
}