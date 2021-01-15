package com.ujjwalsingh.mvpretrofit.model.repos

import com.ujjwalsingh.mvpretrofit.model.remote.CountryRemote


class CountryRepository {
    private val countryRemote:CountryRemote = CountryRemote()

    fun getCountryNameByCapital(city: String) {
        countryRemote.getCountryNameByCapital(city)
    }
    fun getCountry(): String {
        return countryRemote.getCountry()
    }
}