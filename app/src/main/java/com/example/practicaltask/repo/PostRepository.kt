package com.example.practicaltask.repo

import com.android.volley.VolleyError
import com.example.practicaltask.data.Post

interface PostRepository {

    suspend fun getAllPosts(
        successListener: (List<Post>, VolleyError?) -> Unit
    )
}