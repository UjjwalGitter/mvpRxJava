package com.ujjwalsingh.mvpretrofit.model.api

import Country
import com.ujjwalsingh.mvpretrofit.`interface`.Constant
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JobServices {
    @GET(Constant.CAPITAL)
    fun getCountry(@Path("capital")capital:String ): Single<List<Country>>
}