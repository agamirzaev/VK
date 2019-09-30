package com.example.vkwall.data.model.Profile.ProfileStatus

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FieldsGetStatus {

    @SerializedName("response")
    @Expose
    var responseStatus: ResponseStatus? = null
}
