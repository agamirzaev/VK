package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FieldsRecommended {
    @SerializedName("response")
    @Expose
    var response: ResponseRecommended? = null
}
