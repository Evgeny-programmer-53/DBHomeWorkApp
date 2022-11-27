package evgeny.company.dbhomeworkapp.breseryscreen

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import evgeny.company.dbhomeworkapp.R
import evgeny.company.dbhomeworkapp.api.BeerApi
import evgeny.company.dbhomeworkapp.api.BreweryDto
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BreweryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brewery)
        val API_BASE_URL = "https://api.openbrewerydb.org/"

        val httpClient = OkHttpClient.Builder()

        val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )

        val retrofit = builder
            .client(httpClient.build())
            .build()

        val client =  retrofit.create(BeerApi::class.java)

        client.getAllBeers().enqueue(object : Callback<List<BreweryDto>> {
            override fun onResponse(
                call: Call<List<BreweryDto>>,
                response: Response<List<BreweryDto>>
            ) {
                val breweryRecyclerView = findViewById<RecyclerView>(R.id.breweryRecyclerView)
                breweryRecyclerView.layoutManager = LinearLayoutManager(this@BreweryActivity, LinearLayoutManager.VERTICAL, false)
                breweryRecyclerView.adapter = BreweryAdapter(response.body().orEmpty())
            }

            override fun onFailure(call: Call<List<BreweryDto>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}