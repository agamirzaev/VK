package com.example.vkwall.data.model.ProfileWall.Comments

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sticker {
    @SerializedName("product_id")
    @Expose
    var productId: Int? = null
    @SerializedName("sticker_id")
    @Expose
    var stickerId: Int? = null
    @SerializedName("images")
    @Expose
    var images: List<Image>? = null
    @SerializedName("images_with_background")
    @Expose
    var imagesWithBackground: List<ImagesWithBackground>? = null
}
