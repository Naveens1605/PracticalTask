package com.example.practicaltask.utils.volley

import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject
import javax.inject.Inject

class VolleyService @Inject constructor(private val volleySingleton: VolleySingleton) {

    fun sendRequest(
        url: String,
        method: Int,
        responseCallback: VolleyResponseCallback,
        requestBody: JSONObject? = null,
        headers: Map<String, String>? = null,
    ) {
        val jsonObjectRequest = object : JsonObjectRequest(
            method, url, requestBody,
            { response ->
                responseCallback.onSuccessResponse(response)
            }, { error ->
                responseCallback.onFailureResponse(error)
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                return generateHeader(headers)
            }

            override fun getBodyContentType(): String {
                return "application/json"
            }
        }
        volleySingleton.addToRequestQueue(jsonObjectRequest)
    }

    private fun generateHeader(headers: Map<String, String>?): MutableMap<String, String> {
        val headersMap = mutableMapOf<String, String>()
        headersMap["content-type"] = "application/json"
        if (headers != null) headersMap + headers
        return headersMap
    }
}