package com.example.practicaltask.data

data class Response(
    val `data`: List<Data>,
    val message: String,
    val status: Boolean
)