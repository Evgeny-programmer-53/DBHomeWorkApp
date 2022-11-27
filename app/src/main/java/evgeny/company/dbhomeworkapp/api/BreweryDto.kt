package evgeny.company.dbhomeworkapp.api

import com.google.gson.annotations.SerializedName

data class BreweryDto(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("brewery_type")
    val breweryType: String? = null
)