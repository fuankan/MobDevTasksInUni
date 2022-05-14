package kg.fkapps.boredapp.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BoApi {
    @GET("api/activity")
    fun getActivities(): Call<Model>

    @GET("/api/activity/{key}")
    fun getActivityByKey(@Query("key") key: String): Call<Model>

    @GET("/api/activity?price")
    fun getActivityPrice(@Query("price") price: Double): Call<Model>

    companion object {
        var BASE_URL = "https://www.boredapi.com/"

        fun create(): BoApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(BoApi::class.java)
        }
    }
}