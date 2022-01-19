package com.example.geospringdata.sevice

import com.example.geospringdata.model.Country
import org.springframework.stereotype.Service

@Service
class ContryServiceImpl : ContryService {

    override fun getAll(): List<Country> =
        listOf(
            Country(id = 1, name = "Германия"),
            Country(id = 2, name = "Франция"),
            Country(id = 3, name = "Италия"),
        )
}