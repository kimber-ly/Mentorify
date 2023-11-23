package com.example.mentorify.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HistoryBookingDataClass(
    val mentorName: String,
    val dateHistory: String,
    val timeHistory: String
) : Parcelable
