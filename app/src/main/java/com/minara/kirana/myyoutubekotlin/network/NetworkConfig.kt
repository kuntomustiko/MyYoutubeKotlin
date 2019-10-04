package com.minara.kirana.myyoutubekotlin.network

import com.minara.kirana.kumpulanvideokotlin.ui.main.entity.ResultVideo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

object NetworkConfig {

    // TODO 8 membuat Object Network Retrofit, Interceptor, dan service interface
    fun getInterceptor():OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return client
    }

    fun getRetrofit():Retrofit{
        return  Retrofit.Builder().baseUrl("https://www.googleapis.com/youtube/v3/").client(
            getInterceptor()
        ).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun service() = getRetrofit().create(
        YoutubeServices::class.java

    )
}

interface YoutubeServices{
    @GET("search?")
    fun getVideo(@Query("part") part:String,
                 @Query("q") q:String,
                 @Query("key") key:String): Call<ResultVideo>
}