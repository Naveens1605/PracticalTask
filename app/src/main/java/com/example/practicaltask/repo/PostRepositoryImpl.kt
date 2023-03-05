package com.example.practicaltask.repo

import com.android.volley.Request.Method
import com.android.volley.VolleyError
import com.example.practicaltask.App
import com.example.practicaltask.BuildConfig
import com.example.practicaltask.data.Post
import com.example.practicaltask.data.Response
import com.example.practicaltask.utils.volley.VolleyResponseCallback
import com.example.practicaltask.utils.volley.VolleyService
import org.json.JSONObject
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val volleyService: VolleyService) : PostRepository {

    override suspend fun getAllPosts(
        successListener: (List<Post>, VolleyError?) -> Unit
    ) {
        volleyService.sendRequest(BuildConfig.BASE_URL, Method.GET, object : VolleyResponseCallback {
                override fun onSuccessResponse(response: JSONObject) {
                    successListener(App.gson.fromJson(response.toString(), Response::class.java).data,null)
                }

                override fun onFailureResponse(error: VolleyError) {
                    successListener(emptyList(), error)
                }
            }
        )
    }
}