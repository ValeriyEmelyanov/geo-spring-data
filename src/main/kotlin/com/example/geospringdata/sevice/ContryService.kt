package com.example.geospringdata.sevice

import com.example.dto.CountryDto
import com.example.geospringdata.model.Country

interface ContryService {
    fun getAll(): List<Country>

    fun getById(id: Int): Country

    fun create(country: CountryDto): Country

    fun update(id: Int, country: CountryDto): Country
}