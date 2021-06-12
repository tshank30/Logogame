package com.example.logogame.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.logogame.api.LogoApi
import com.example.logogame.base.BaseViewModel
import com.example.logogame.models.LogoData
import javax.inject.Inject

class MainViewModel() : BaseViewModel() {

    @Inject
    lateinit var postApi: LogoApi

    val getLogoData:MutableLiveData<LogoData> by lazy {
        MutableLiveData<LogoData>()
    }



    fun getLogoData():MutableLiveData<LogoData>{
        return postApi.getPosts()
    }

}