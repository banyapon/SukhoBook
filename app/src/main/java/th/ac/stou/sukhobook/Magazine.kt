package th.ac.stou.sukhobook

import com.google.gson.annotations.SerializedName

data class Magazine(
    @SerializedName("price") val price: Int,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("title") val title: String,
    @SerializedName("authors") val authors: List<String>
)
