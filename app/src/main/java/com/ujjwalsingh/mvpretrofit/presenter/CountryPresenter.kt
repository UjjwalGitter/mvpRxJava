package com.ujjwalsingh.mvpretrofit.presenter

import android.util.Log
import com.ujjwalsingh.mvpretrofit.`interface`.CountryInterface
import com.ujjwalsingh.mvpretrofit.model.repos.CountryRepo

class CountryPresenter(countryView: CountryInterface.CountryView): CountryInterface.CountryPresenter {
    private var view: CountryInterface.CountryView = countryView
    private var model: CountryInterface.CountryModel = CountryRepo()

    override fun networkCall(city: String) {
        model.getCountryNameByCapital(city)
        view.updateViewData()
    }

    override fun showCountry(): String {
        return model.getCountry()
    }

}