package com.example.logogame.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


abstract class BaseActivity<VM : BaseViewModel>: AppCompatActivity(){

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(getViewModel())
        addObservers()
    }

    open fun addObservers(){
    }

    abstract fun getViewModel():Class<VM>




}