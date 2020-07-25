package dev.owuor91.domain.models

import com.google.gson.annotations.SerializedName

data class Post(
    var id: Int,
    @SerializedName("userId") var userId: Int,
    var title: String,
    var body: String
)