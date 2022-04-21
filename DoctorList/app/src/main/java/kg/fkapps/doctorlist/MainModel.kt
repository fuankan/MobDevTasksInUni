package kg.fkapps.doctorlist

import android.widget.ImageView
import java.io.Serializable

data class MainModel(var name: String, var number: String, var speciality: String, var imageView: Int) : Serializable