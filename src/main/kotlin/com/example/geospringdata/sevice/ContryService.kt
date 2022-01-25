package com.example.geospringdata.sevice

import com.example.geospringdata.dto.CountryDto

interface ContryService {
    fun getAll(): List<CountryDto>

    fun getById(id: Int): CountryDto

    fun create(countryDto: CountryDto): CountryDto

    fun update(id: Int, countryDto: CountryDto): CountryDto

    fun deleteById(id: Int)
}