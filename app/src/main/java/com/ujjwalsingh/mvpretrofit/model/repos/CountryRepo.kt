package com.ujjwalsingh.mvpretrofit.model.repos

import Country
import android.util.Log
import com.ujjwalsingh.mvpretrofit.`interface`.CountryInterface
import com.ujjwalsingh.mvpretrofit.model.api.JobApi
import com.ujjwalsingh.mvpretrofit.model.api.JobServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CountryRepo: CountryInterface.CountryModel {

    private val disposal = CompositeDisposable()
    private var country=""
    private var apiClient : JobServices = JobApi.client.create(JobServices::class.java)

    override fun getCountryNameByCapital(
        city: String) {
        disposal.add(
                apiClient.getCountry(city).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {

                    override fun onSuccess(countryList: List<Country>) {
                        val result = countryList[0].name
                        country = result
                    }
                    override fun onError(e: Throwable) {
                        Log.i("error","Not able to fetch the data")
                    }
                })
        )
    }

    override fun getCountry(): String {
        return country
    }
    
}







