package com.example.geospringdata.repository

import com.example.geospringdata.model.Country
import org.springframework.data.repository.CrudRepository

interface CountryRepository: CrudRepository<Country, Int> {
}