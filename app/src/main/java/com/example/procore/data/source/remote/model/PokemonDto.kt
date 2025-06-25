package com.example.procore.data.source.remote.model


import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("data")
    val data: List<Data>?=null
)

data class Data(
    @SerializedName("hp")
    val hp: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("images")
    val images: Images?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("types")
    val types: List<String?>?
)

data class Images(
    @SerializedName("large")
    val large: String?,
    @SerializedName("small")
    val small: String?
)
