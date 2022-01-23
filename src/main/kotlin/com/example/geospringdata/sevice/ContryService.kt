package com.example.geospringdata.sevice

import com.example.dto.CountryDto
import com.example.geospringdata.model.Country

interface ContryService {
    fun getAll(): List<Country>

    fun getById(id: Int): Country

    fun create(countryDto: CountryDto): Country

    fun update(id: Int, countryDto: CountryDto): Country

    fun deleteById(id: Int)
}