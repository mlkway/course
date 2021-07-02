package com.raywenderlich.coursesshemajamebeli.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class Course(
    @Json(name = "background_color_precent")
    val backgroundColorPrecent: String,
    @Json(name = "color")
    val color: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "precent")
    val precent: String,
    @Json(name = "title")
    val title: String
)