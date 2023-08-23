package com.example.flow_pagination_api.UI.data.Repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.flow_pagination_api.UI.data.Dogs
import com.example.flow_pagination_api.UI.data.Network.ApiService
import retrofit2.HttpException
import java.io.IOException

class DogsPagingSource constructor(private val apiService: ApiService): PagingSource<Int, Dogs>() {



    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Dogs> {
        //if it have no page then by default page is 1
        val page =params.key?:1
        return try {
            //params.loadsize for load the limit 1 then 2 then 3 so on
            val response = apiService.getAllDogs(page, params.loadSize)
            LoadResult.Page(
                response,
                prevKey = if (page==1)null else page-1,
                nextKey = if (response.isEmpty())null else page+1
            )
        }catch (e:IOException){
            LoadResult.Error(e)
        }catch (e:HttpException){
            LoadResult.Error(e)



        }
    }

    override fun getRefreshKey(state: PagingState<Int, Dogs>): Int? {
        return null
    }
}