package com.example.logogame.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import com.example.logogame.R
import com.example.logogame.base.BaseFragment
import com.example.logogame.viewmodels.MainViewModel

class LogoGameFragment() : BaseFragment<MainViewModel>() {

    companion object {
        fun newInstance() = LogoGameFragment()
    }

    override var layoutRes: Int = R.layout.main_fragment


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun setViewModel() {
        activity?.let{
            getViewModel(it)
        }

    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

}