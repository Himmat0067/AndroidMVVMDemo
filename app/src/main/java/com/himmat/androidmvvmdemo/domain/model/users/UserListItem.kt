package com.himmat.androidmvvmdemo.domain.model.users

data class UserListItem(
    val address: Address?,
    val company: Company?,
    val email: String?,
    val id: Int?,
    val name: String?,
    val phone: String?,
    val username: String?,
    val website: String?
)