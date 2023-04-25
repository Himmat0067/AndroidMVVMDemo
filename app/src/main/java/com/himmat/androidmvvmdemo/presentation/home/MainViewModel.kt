package com.himmat.androidmvvmdemo.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himmat.androidmvvmdemo.domain.model.users.UserListItem
import com.himmat.androidmvvmdemo.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/**
 * Created by Himmat Sawant.
 * Date : 24-04-2023.
 * Description :
 */

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    private val _userList = MutableLiveData<List<UserListItem>>()

    val userList: LiveData<List<UserListItem>> get() = _userList

    fun getUserList(){

        viewModelScope.launch {
            val users = userRepository.getAllUsers()
            _userList.postValue(users)
        }
    }
}