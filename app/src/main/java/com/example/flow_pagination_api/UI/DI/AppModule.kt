package com.example.flow_pagination_api.UI.DI

import com.example.flow_pagination_api.UI.data.Network.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    @Provides
    @Singleton
    fun provideretrofit()=Retrofit.Builder().baseUrl(ApiService.BASE_URL).addConverterFactory(MoshiConverterFactory.create(
        moshi)).build().create(ApiService::class.java)



}