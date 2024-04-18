package com.example.myproject.app.data.remote.dto

import com.squareup.moshi.Json

data class YourDto (

    @Json(name = "id") // same as @seralizedname from gson. this is field name from api, it's not necessary if it's has the same name
    val id: String,

    @Json(name = "name")
    val name: String
)