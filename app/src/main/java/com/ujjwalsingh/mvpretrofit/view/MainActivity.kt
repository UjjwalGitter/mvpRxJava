package com.ujjwalsingh.mvpretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ujjwalsingh.mvpretrofit.R
import com.ujjwalsingh.mvpretrofit.`interface`.CountryInterface
import com.ujjwalsingh.mvpretrofit.presenter.CountryPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CountryInterface.CountryView {
    lateinit var cityName:String
    lateinit var presenter:CountryInterface.CountryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = CountryPresenter(this)

        button.setOnClickListener{
            cityName = edittext.text.toString()
            presenter.networkCall(cityName)
        }
    }

    override fun updateViewData() {
        val k = presenter.showCountry()
        textview.text = k
    }

}