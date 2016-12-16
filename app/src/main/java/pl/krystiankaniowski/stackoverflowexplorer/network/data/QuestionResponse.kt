package pl.krystiankaniowski.stackoverflowexplorer.network.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class QuestionResponse(
        @SerializedName("items")
        @Expose
        val items: List<Question>?
)
