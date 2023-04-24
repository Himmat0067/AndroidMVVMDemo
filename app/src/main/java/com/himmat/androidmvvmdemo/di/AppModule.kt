package com.himmat.androidmvvmdemo.di

import com.himmat.androidmvvmdemo.common.Constants
import com.himmat.androidmvvmdemo.data.remote.WebApiService
import com.himmat.androidmvvmdemo.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Himmat Sawant on 24-04-2023.
 *
 * Description : Modules are used to add bindings to Hilt, or in other words, to tell Hilt how to provide instances of different types.
 *               In Hilt modules, you can include bindings for types that cannot be constructor-injected such as interfaces or classes
 *               that are not contained in your project
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // For request/response logging
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    // Client
    @Provides
    @Singleton
    fun provideOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    // Retrofit Builder
    @Provides
    @Singleton
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder{

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
    }

    // Create WebApiService to provide implementation of abstract method
    @Provides
    @Singleton
    fun provideWebApiService(retrofit: Retrofit.Builder): WebApiService{
        return  retrofit.build().create(WebApiService::class.java)
    }


    // Provide UserRepository object to inject in MainViewModel
    @Provides
    @Singleton
    fun provideUserRepository(webApiService: WebApiService): UserRepository{
        return UserRepository(webApiService)
    }
}