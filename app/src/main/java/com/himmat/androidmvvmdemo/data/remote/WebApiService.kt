package com.himmat.androidmvvmdemo.data.remote

import com.himmat.androidmvvmdemo.common.EndPoints
import com.himmat.androidmvvmdemo.domain.model.users.UserList
import retrofit2.http.GET

interface WebApiService {

    @GET(EndPoints.USERS)
    suspend fun getAllUsers(): UserList
}