package com.aelfattah.ahmed.appcodingtask.ui

import com.aelfattah.ahmed.appcodingtask.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getActivityBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

}