package com.example.myproject.app.feature.sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproject.app.data.remote.dto.YourDto
import com.example.myproject.app.domain.subscribers.Resource
import com.example.myproject.app.domain.usecase.yourusecase.DataUsecase
import com.example.myproject.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val dataUsecase: DataUsecase
) : BaseViewModel() {

    val getFavouriteResult = MutableLiveData<Resource<YourDto>>()

    fun getData() {
        viewModelScope.launch {
            dataUsecase.getDataUseCase().collect {
                getFavouriteResult.postValue(it)
            }
        }
    }

    /** In case need to pass variable to usecase */
//    fun getData(variable: String) {
//        viewModelScope.launch {
//            dataUsecase.getDataUseCase(variable).collect {
//                getFavouriteResult.postValue(it)
//            }
//        }
//    }
}