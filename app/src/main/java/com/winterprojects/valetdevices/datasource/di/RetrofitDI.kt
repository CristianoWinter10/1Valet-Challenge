package com.winterprojects.valetdevices.datasource.di


import com.winterprojects.valetdevices.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitDI {
    val module = module {
        single<Retrofit.Builder> {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        }

        single<Retrofit> {
            get<Retrofit.Builder>().build()
        }
    }
}