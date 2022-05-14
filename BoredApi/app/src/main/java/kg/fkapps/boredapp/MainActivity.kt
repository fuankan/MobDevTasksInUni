package kg.fkapps.boredapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kg.fkapps.boredapp.data.BoApi
import kg.fkapps.boredapp.data.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var btnGo: Button? = null
    var activity: TextView? = null
    var price: TextView? = null
    var link: TextView? = null
    var type: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        btnGo!!.setOnClickListener {
            val apiInterface = BoApi.create().getActivities()
            apiInterface.enqueue(object : Callback<Model?> {
                override fun onResponse(call: Call<Model?>, response: Response<Model?>) {
                    if (response.isSuccessful && response.body() != null) {
                        type?.text = response.body()!!.type.uppercase()
                        price?.text = response.body()!!.price + " dollars"
                        activity?.text = response.body()!!.activity
                        link?.text = response.body()!!.link
                    }
                }

                override fun onFailure(call: Call<Model?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
                }

            })

        }
    }

    private fun init() {
        btnGo = findViewById(R.id.btnGo)
        activity = findViewById(R.id.activity)
        price = findViewById(R.id.price)
        link = findViewById(R.id.link)
        type = findViewById(R.id.type)
    }
}