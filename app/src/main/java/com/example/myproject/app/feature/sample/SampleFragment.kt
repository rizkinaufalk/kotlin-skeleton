package com.example.myproject.app.feature.sample

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myproject.BR
import com.example.myproject.base.BaseFragment
import com.example.myproject.databinding.FragmentSampleBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import id.co.kalacakra.bcas.ext.activity.autoCleaned

@FragmentScoped
@AndroidEntryPoint
class SampleFragment : BaseFragment<FragmentSampleBinding, SampleViewModel>() {

    @FragmentScoped
    override val bindingVariable: Int = BR.vmSampleFragment
    override val viewModel: SampleViewModel by viewModels()
    override val binding: FragmentSampleBinding by autoCleaned {
        (FragmentSampleBinding.inflate(layoutInflater))
    }

}