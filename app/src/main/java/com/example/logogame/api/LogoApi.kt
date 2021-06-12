package com.example.logogame.api

import androidx.lifecycle.MutableLiveData
import com.example.logogame.models.LogoData
import retrofit2.http.GET


interface LogoApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/getLogos")
    fun getPosts(): MutableLiveData<LogoData>
}