package com.example.logogame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.logogame.R
import com.example.logogame.base.BaseFragment
import com.example.logogame.viewmodels.MainViewModel

class StartGameFragment() : BaseFragment<MainViewModel>() {

    companion object {
        fun newInstance() = StartGameFragment()
    }

    override var layoutRes: Int = R.layout.start_game



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.findViewById<Button>(R.id.start_button)?.setOnClickListener {

        }
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