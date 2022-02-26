package com.aelfattah.ahmed.appcodingtask.ui.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelfattah.ahmed.appcodingtask.data.models.File
import com.aelfattah.ahmed.appcodingtask.databinding.ActivityMainBinding
import com.aelfattah.ahmed.appcodingtask.di.viewModelsUtils.ViewModelProviderFactory
import com.aelfattah.ahmed.appcodingtask.ui.BaseActivity
import com.aelfattah.ahmed.appcodingtask.utils.NetworkUtils
import com.aelfattah.ahmed.appcodingtask.utils.isVisible
import com.aelfattah.ahmed.appcodingtask.utils.showSnack
import com.aelfattah.ahmed.appcodingtask.utils.showToast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(), FileResponseAdapter.FileResponseListener {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var fileResponseAdapter: FileResponseAdapter
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String?>

    private val mainViewModel by lazy {
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }
    private var disposable: Disposable? = null


    override fun getActivityBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    showToast("Permission is granted")
                } else {
                    showSnack(
                        "Permission is not granted allow it"
                    ) {
                        ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        )
                    }
                }
            }
        if (!checkPermission())
            requestPermission()

        fileResponseAdapter = FileResponseAdapter(this)
        binding.content.rvFiles.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = fileResponseAdapter
        }

        mainViewModel.errorMessage.observe(this) {
            binding.content.root.isVisible(false)
            if (it.contains("Unable to resolve host"))
                binding.empty.root.isVisible(true)
            else {
                binding.error.root.isVisible(true)
                binding.error.tvMessage.text = it
            }
        }
        mainViewModel.loading.observe(this) {
            binding.content.pbLoading.isVisible(it)
        }
        mainViewModel.progress.observe(this) {
            binding.content.pbDownloadPercentage.isVisible(true)
            binding.content.pbDownloadPercentage.progress = it
        }
        mainViewModel.downloadFinished.observe(this) {
            if (it) {
                binding.content.pbDownloadPercentage.isVisible(false)
                fileResponseAdapter.notifyDataSetChanged()
            }
        }
        mainViewModel.filesResponse.observe(this) {
            Log.e("TAG", "onCreate: ${it.size}")
            binding.content.root.isVisible(true)
            fileResponseAdapter.setList(it)
        }
    }

    override fun onFileDownloadClicked(file: File) {
        disposable = NetworkUtils.hasInternetConnection()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { connected ->
                if (connected) {
                    val targetFile = java.io.File(cacheDir, file.name)
                    mainViewModel.downloadFile(targetFile, file)
                } else {
                    showSnack(
                        "There is no internet, check your internet and try again",
                        null
                    )
                }
            }
    }

    private fun checkPermission(): Boolean {
        return when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) -> {
                true
            }
            else -> {
                false
            }
        }
    }

    private fun requestPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED -> {
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) -> {
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}