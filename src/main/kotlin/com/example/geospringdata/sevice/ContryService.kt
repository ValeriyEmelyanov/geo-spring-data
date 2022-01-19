package com.example.geospringdata.sevice

import com.example.geospringdata.model.Country

interface ContryService {
    fun getAll(): List<Country>
}