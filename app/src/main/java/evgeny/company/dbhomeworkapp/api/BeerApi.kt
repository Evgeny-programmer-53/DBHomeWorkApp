package evgeny.company.dbhomeworkapp.api

import retrofit2.Call
import retrofit2.http.GET

interface BeerApi {
    @GET("breweries")
    fun getAllBeers(): Call<List<BreweryDto>>
}
