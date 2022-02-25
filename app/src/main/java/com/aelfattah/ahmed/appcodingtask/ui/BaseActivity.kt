package com.aelfattah.ahmed.appcodingtask.ui

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<B : ViewBinding> : DaggerAppCompatActivity() {
    private var _binding: B? = null
    val binding: B get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getActivityBinding()
        setContentView(binding.root)
    }

    abstract fun getActivityBinding(): B

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}