package pl.krystiankaniowski.stackoverflowexplorer.network.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("reputation")
    @Expose
    val reputation: Int? ,
    @SerializedName("user_id")
    @Expose
    val userId: Int? ,
    @SerializedName("user_type")
    @Expose
    val userType: String? ,
    @SerializedName("accept_rate")
    @Expose
    val acceptRate: Int? ,
    @SerializedName("profile_image")
    @Expose
    val profileImage: String? ,
    @SerializedName("display_name")
    @Expose
    val displayName: String? ,
    @SerializedName("link")
    @Expose
    val link: String?
)