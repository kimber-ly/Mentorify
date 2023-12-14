package com.example.mentorify.api

import com.google.gson.annotations.SerializedName

data class UserLogin(

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("password")
    val password: String? = null

)
