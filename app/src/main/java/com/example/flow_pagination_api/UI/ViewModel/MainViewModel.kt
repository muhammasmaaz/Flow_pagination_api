package com.example.flow_pagination_api.UI.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.flow_pagination_api.UI.data.Dogs
import com.example.flow_pagination_api.UI.data.Network.ApiService
import com.example.flow_pagination_api.UI.data.Repository.DogsPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(private val apiService: ApiService):ViewModel() {


    fun getAllDogs():Flow<PagingData<Dogs>> = Pager(
        //ek time ma kitna data load karwana hai mean ek page ma kitny size of item/data hony chahiya
        config = PagingConfig(20, enablePlaceholders = false )
    ){
        DogsPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)


}