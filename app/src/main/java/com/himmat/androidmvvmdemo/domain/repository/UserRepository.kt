package com.himmat.androidmvvmdemo.domain.repository

import com.himmat.androidmvvmdemo.data.remote.WebApiService
import com.himmat.androidmvvmdemo.domain.model.users.UserList

/**
 * Created by Himmat Sawant.
 * Date : 24-04-2023.
 * Description : This is the repository help to access the remote user data from api.
 *
 *               This Repository work as intermediate b/w Presentation and Data layer
 *
 *               Here we need to inject WebServiceApi to make network request & for this we have provided the
 *               instance of this WebApiService using Hilt's Provider method in AppModule
 *
 */

class UserRepository(private val webApiService: WebApiService) {

    private val TAG = "UserRepository"

    suspend fun getAllUsers():UserList{
       return webApiService.getAllUsers()
    }
}