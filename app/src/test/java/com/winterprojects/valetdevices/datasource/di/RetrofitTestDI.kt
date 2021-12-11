package com.winterprojects.valetdevices.datasource.di

import com.winterprojects.valetdevices.BuildConfig
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit.Builder

private const val SUCCESS_CODE: Int = 200


object RetrofitTestDI {
    val module = module {
        factory {
            MockInterceptor()
        }
        factory {
            OkHttpClient
                .Builder()
                .addInterceptor(get<MockInterceptor>())
                .build()
        }

        factory<Builder> {
            Builder()
                .client(get())
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        }

        factory<Retrofit> {
            get<Builder>()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()
        }
    }
}

private class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url.toUri().toString()
        val responseString = when {
            uri.endsWith("devices") -> getListDevices
            else -> ""
        }

        return Response.Builder()
            .code(SUCCESS_CODE)
            .protocol(Protocol.HTTP_2)
            .message(responseString)
            .request(chain.request())
            .body(
                responseString.toByteArray()
                    .toResponseBody("application/json".toMediaTypeOrNull())
            )
            .addHeader("content-type", "application/json")
            .build()

    }

    private val getListDevices = """[
  {
    "Id": "1234",
    "Type": "Sensor",
    "Price": 20,
    "Currency": "USD",
    "isFavorite": false,
    "imageUrl": "",
    "Title": "Test Sensor",
    "Description": ""
  },
  {
    "Id": "1235",
    "Type": "Thermostat",
    "Price": 25,
    "Currency": "USD",
    "isFavorite": false,
    "imageUrl": "",
    "Title": "Test Thermostat",
    "Description": ""
  }
]"""
}