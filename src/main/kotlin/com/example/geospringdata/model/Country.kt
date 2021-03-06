package com.example.geospringdata.model

import javax.persistence.CascadeType;
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String,
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    var cities: List<City> = emptyList(),
)
