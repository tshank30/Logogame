package com.example.logogame.activities

import android.os.Bundle
import com.example.logogame.R
import com.example.logogame.base.BaseActivity
import com.example.logogame.fragments.LogoGameFragment
import com.example.logogame.fragments.StartGameFragment
import com.example.logogame.viewmodels.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, StartGameFragment.newInstance())
                    .commitNow()
        }
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }
}