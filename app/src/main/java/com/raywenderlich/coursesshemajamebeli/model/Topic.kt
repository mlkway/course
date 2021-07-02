package com.raywenderlich.coursesshemajamebeli.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class Topic(
    @Json(name = "color")
    val color: String,
    @Json(name = "duration")
    val duration: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "type")
    val type: String
)