package com.himmat.androidmvvmdemo.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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


}