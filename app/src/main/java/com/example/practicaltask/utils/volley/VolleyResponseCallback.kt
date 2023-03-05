package com.example.practicaltask.utils.volley

import com.android.volley.VolleyError
import org.json.JSONObject

interface VolleyResponseCallback {
    fun onSuccessResponse(response: JSONObject)
    fun onFailureResponse(error: VolleyError)
}