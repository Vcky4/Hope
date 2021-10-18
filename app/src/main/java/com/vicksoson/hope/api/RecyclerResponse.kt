package com.vicksoson.hope.api

import com.google.gson.annotations.SerializedName

data class RecyclerResponse(
    @SerializedName("albumId")
    var albumId: kotlin.Int,
    @SerializedName("id")
    var id: kotlin.Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("quantity")
    val length: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("size")
    val size: String
)
