package com.ujjwalsingh.mvpretrofit.presenter

import com.ujjwalsingh.mvpretrofit.`interface`.CountryInterface
import com.ujjwalsingh.mvpretrofit.model.remote.CountryRemote
import com.ujjwalsingh.mvpretrofit.model.repos.CountryRepository

class CountryPresenter(countryView: CountryInterface.CountryView): CountryInterface.CountryPresenter {
    private var view: CountryInterface.CountryView = countryView
    private var repository:CountryRepository = CountryRepository()

    override fun onGetButtonTappedNetworkCall(city: String) {
        repository.getCountryNameByCapital(city)
        view.updateViewData()
    }

    override fun showCountry(): String {
        return repository.getCountry()
    }

}