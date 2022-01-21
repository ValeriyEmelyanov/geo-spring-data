package com.example.geospringdata.sevice

import com.example.dto.CountryDto
import com.example.exception.CountryNotFoundException
import com.example.geospringdata.model.Country
import com.example.geospringdata.repository.CountryRepository
import org.springframework.stereotype.Service

@Service
class ContryServiceImpl(
    private val countryRepository: CountryRepository,
) : ContryService {

    override fun getAll(): List<Country> =
        countryRepository.findAll().toList()

    override fun getById(id: Int): Country = countryRepository.findById(id)
        .orElseThrow { CountryNotFoundException() }

    override fun create(countryDto: CountryDto): Country {
        val country = Country(
            name = countryDto.name
        )
        return countryRepository.save(country)
    }

    override fun update(id: Int, countryDto: CountryDto): Country {
        val byId = getById(id)
        val newCountry = byId.copy(name = countryDto.name)
        return countryRepository.save(newCountry)
    }
}