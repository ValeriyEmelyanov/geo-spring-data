package com.example.geospringdata.sevice

import com.example.geospringdata.dto.CityDto
import com.example.geospringdata.dto.CountryDto
import com.example.geospringdata.exception.CountryNotFoundException
import com.example.geospringdata.model.City
import com.example.geospringdata.model.Country
import com.example.geospringdata.repository.CountryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ContryServiceImpl(
    private val countryRepository: CountryRepository,
) : ContryService {

    override fun getAll(): List<CountryDto> =
        countryRepository.findAllWithJoin().map { it.toDto() }


    override fun getById(id: Int): CountryDto = countryRepository.findByIdOrNull(id)
        ?.toDto()
        ?: throw CountryNotFoundException(id)

    override fun create(countryDto: CountryDto): CountryDto {
        val country = Country(
            name = countryDto.name,
        )
        country.cities = toCityList(countryDto.cities, country)
        return (countryRepository.save(country)).toDto()
    }

    override fun update(id: Int, countryDto: CountryDto): CountryDto {
        val byId = countryRepository.findByIdOrNull(id) ?: throw CountryNotFoundException(id)
        val newCountry = byId.copy(
            name = countryDto.name,
        )
        newCountry.cities = toCityList(countryDto.cities, newCountry)
        return (countryRepository.save(newCountry)).toDto()
    }

    override fun deleteById(id: Int) {
        getById(id)
        countryRepository.deleteById(id)
    }

    private fun Country.toDto(): CountryDto =
        CountryDto(
            name = this.name,
            cities = this.cities.map { CityDto(name = it.name) }
        )

    private fun toCityList(dtos: List<CityDto>, country: Country): List<City> =
        dtos.map {
            City(
                name = it.name,
                country = country
            )
        }
}