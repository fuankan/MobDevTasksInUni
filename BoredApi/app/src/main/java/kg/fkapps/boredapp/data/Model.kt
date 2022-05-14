package kg.fkapps.boredapp.data

import com.google.gson.annotations.SerializedName


data class Model(
    @SerializedName("key")
    var key: String,

    @SerializedName("activity")
    var activity: String,

    @SerializedName("price")
    var price: String,

    @SerializedName("type")
    var type: String,

    @SerializedName("link")
    var link: String)