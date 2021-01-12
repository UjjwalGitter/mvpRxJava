package com.ujjwalsingh.mvpretrofit.model.api

import com.ujjwalsingh.mvpretrofit.`interface`.Constant
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class JobApi {
    companion object{
        private var retrofit: Retrofit?=null

        val client: Retrofit get() {
            if(retrofit==null){
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constant.BASE_URL)
                    .build()
            }
            return retrofit!!
        }
    }
}