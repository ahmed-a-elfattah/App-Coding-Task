package com.aelfattah.ahmed.appcodingtask.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aelfattah.ahmed.appcodingtask.databinding.ActivityMainBinding
import com.aelfattah.ahmed.appcodingtask.di.viewModelsUtils.ViewModelProviderFactory
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private val mainViewModel by lazy {
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun getActivityBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.loadData()
    }
}