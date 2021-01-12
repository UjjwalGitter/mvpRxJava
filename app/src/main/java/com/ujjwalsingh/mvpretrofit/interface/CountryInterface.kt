package com.ujjwalsingh.mvpretrofit.`interface`

interface CountryInterface {

    interface CountryModel{
        fun getCountryNameByCapital(city:String)
        fun getCountry():String
    }
    interface CountryView{
       fun updateViewData()
    }
    interface CountryPresenter{
        fun networkCall(city:String)
        fun showCountry():String
    }
}