package com.bazan.countrywiki.core.dagger

import android.content.Context
import android.net.ConnectivityManager
import com.bazan.countrywiki.data.network.country.CountryApiClient
import com.bazan.countrywiki.domain.exceptions.NoConnectivityException
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://restcountries.com/"

    @Provides
    @Singleton
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Singleton
    @Provides
    fun provideInterceptor(connectivityManager: ConnectivityManager): Interceptor {

        return Interceptor { chain ->
            val originalRequest = chain.request()

            if (!isConnected(connectivityManager)) {
                throw NoConnectivityException()
            }

            val requestWithToken = originalRequest.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control","no-cache")
                .addHeader("User-Agent",System.getProperty("http.agent"))
                .build()
            chain.proceed(requestWithToken)
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptor: Interceptor,
        @ApplicationContext context: Context
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providePicasso(@ApplicationContext context: Context, httpClient: OkHttpClient): Picasso {
        val pica = Picasso.Builder(context)
            .downloader(OkHttp3Downloader(httpClient))
            .build()

        Picasso.setSingletonInstance(pica)
        return pica
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthApiClient(retrofit: Retrofit): CountryApiClient {
        return retrofit.create(CountryApiClient::class.java)
    }

    private fun isConnected(connectivityManager: ConnectivityManager): Boolean {
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}