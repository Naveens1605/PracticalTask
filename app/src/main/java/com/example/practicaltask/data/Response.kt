package com.example.practicaltask.data

data class Response(
    val `data`: List<Post>,
    val message: String,
    val status: Boolean
)