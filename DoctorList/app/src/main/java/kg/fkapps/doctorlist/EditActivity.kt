package kg.fkapps.doctorlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.fkapps.doctorlist.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private val imList = listOf(R.drawable.docdefaultphoto)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons () = with(binding) {
        btnDone.setOnClickListener {
            val mainModel = MainModel(etName.text.toString(), etPhone.text.toString(), etSpeciality.text.toString(), imList[0])
            val editIntent = Intent().apply {
                putExtra("mainModel", mainModel)
            }

            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}