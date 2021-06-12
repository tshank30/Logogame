package com.example.logogame.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider


abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    lateinit var viewModel: VM

    abstract fun setViewModel()

    abstract fun getViewModel(): Class<VM>

    abstract var layoutRes: Int

    fun getViewModel(fragment: Fragment): VM {
        viewModel = ViewModelProvider(fragment).get(getViewModel())
        return viewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    fun getViewModel(activity: FragmentActivity): VM {
        viewModel = ViewModelProvider(activity).get(getViewModel())
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
        addObservers()
    }

    open fun addObservers() {
    }


}