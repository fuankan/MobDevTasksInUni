package kg.fkapps.doctorlist

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kg.fkapps.doctorlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var editLauncher: ActivityResultLauncher<Intent>? = null
    private val doctorList = ArrayList<MainModel>()
    private val adapter = MainAdapter(doctorList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK) {
                adapter.addData(it.data?.getSerializableExtra("mainModel") as MainModel)
            }
        }
    }


    private fun init() {
        /*var recyclerView = findViewById<RecyclerView>(R.id.rv_doctors)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var list: MutableList<MainModel> = mutableListOf()
        var adapter = MainAdapter(list, this)
        recyclerView.adapter = adapter*/

        val imList = listOf(R.drawable.docdefaultphoto)
        doctorList.add(0, MainModel("Alesha Popovich", "0777009000", "Vrach", imList[0]))
        doctorList.add(1, MainModel("Alesha Popovich", "0777009000", "Vrach", imList[0]))
        doctorList.add(2, MainModel("Alesha Popovich", "0777009000", "Vrach", imList[0]))
        doctorList.add(3, MainModel("Alesha Popovich", "0777009000", "Vrach", imList[0]))
        doctorList.add(4, MainModel("Alesha Popovich", "0777009000", "Vrach", imList[0]))
        doctorList.add(5, MainModel("Alesha Popovich", "0700009000", "Vrach", imList[0]))
        doctorList.add(6, MainModel("Alesha Popovich", "0770009000", "Vrach", imList[0]))
        doctorList.add(7, MainModel("Alesha Popovich", "0777009000", "Vrach", imList[0]))
        doctorList.add(8, MainModel("Alesha Popovich", "0777009000", "Vrach", imList[0]))
        doctorList.add(9, MainModel("Alesha Popovich", "0777009000", "Vrach", imList[0]))
        binding.apply {
            rvDoctors.layoutManager = LinearLayoutManager(this@MainActivity)
            rvDoctors.adapter = adapter
            btnAdd.setOnClickListener{
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }
}