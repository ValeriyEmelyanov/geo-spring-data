package com.example.geospringdata.dto

data class CountryDto(
    val name: String,
    val cities: List<CityDto>,
)