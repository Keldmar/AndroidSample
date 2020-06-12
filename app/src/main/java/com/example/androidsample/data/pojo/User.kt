package com.example.androidsample.data.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User (
    var id: String,
    var name: String,
    val image: Int
): Parcelable