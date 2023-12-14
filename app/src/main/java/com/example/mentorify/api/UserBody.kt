package com.example.mentorify.api

import com.google.gson.annotations.SerializedName

data class UserBody(

	@field:SerializedName("institution")
	val institution: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
