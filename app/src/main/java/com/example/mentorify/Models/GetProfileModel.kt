package com.example.mentorify.Models

import com.google.gson.annotations.SerializedName

data class GetProfileModel(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null
)

data class User(

	@field:SerializedName("gender")
	val gender: Any? = null,

	@field:SerializedName("city")
	val city: Any? = null,

	@field:SerializedName("birth_date")
	val birthDate: Any? = null,

	@field:SerializedName("rating")
	val rating: Any? = null,

	@field:SerializedName("bio")
	val bio: Any? = null,

	@field:SerializedName("experience")
	val experience: Any? = null,

	@field:SerializedName("time_zone")
	val timeZone: Any? = null,

	@field:SerializedName("certification")
	val certification: Any? = null,

	@field:SerializedName("institution")
	val institution: String? = null,

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("balance")
	val balance: Any? = null,

	@field:SerializedName("role_id")
	val roleId: Int? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("review")
	val review: Any? = null,

	@field:SerializedName("skill")
	val skill: Any? = null,

	@field:SerializedName("topic")
	val topic: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)
