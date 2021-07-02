package com.raywenderlich.coursesshemajamebeli.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ApiData(
    @Json(name = "courses")
    val courses: List<Course>,
    @Json(name = "topic")
    val topic: List<Topic>
)