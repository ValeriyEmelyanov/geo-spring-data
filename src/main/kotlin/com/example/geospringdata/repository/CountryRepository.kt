package com.example.geospringdata.repository

import com.example.geospringdata.model.Country
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CountryRepository : CrudRepository<Country, Int> {

    @Query("select distinct c from Country c join fetch c.cities")
    fun findAllWithJoin(): List<Country>
}