package com.example.myproject.app.feature.activity.mainactivity

import androidx.lifecycle.ViewModelProvider
import com.example.myproject.BR
import com.example.myproject.base.BaseActivity
import com.example.myproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val bindingVariable: Int = BR.vmActMain
    override val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onInitViews() {
        setContentView(binding.root)
    }
}