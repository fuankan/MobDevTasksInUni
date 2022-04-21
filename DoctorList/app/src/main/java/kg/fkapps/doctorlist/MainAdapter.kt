package kg.fkapps.doctorlist

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


open class MainAdapter(private var list: ArrayList<MainModel>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    //private var listener: ItemClickListener? = null

    fun addData(model: MainModel) {
        list.add(model)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doctor, parent, false)
        return MainViewHolder(view)
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(list[position])

        holder.popMenu.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", holder.txtPhone.text.toString(), null))
            it.context.startActivity(dialIntent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView
        var txtPhone: TextView
        var imageView: ImageView
        var popMenu: ImageView
        val txtSpeciality: TextView
        var model: MainModel? = null

        fun onBind(model: MainModel) {
            this.model = model
            txtPhone.text = model.number
            txtName.text = model.name
            txtSpeciality.text = model.speciality
            imageView.setImageResource(model.imageView)
        }

        init {
            //itemView.setOnClickListener(this)
            txtName = itemView.findViewById(R.id.txtName)
            txtPhone = itemView.findViewById(R.id.tvPhone)
            imageView = itemView.findViewById(R.id.ivDoctor)
            popMenu = itemView.findViewById(R.id.pop_menu)
            txtSpeciality = itemView.findViewById(R.id.tvSpeciality)
        }
    }

    /*fun setOnClickListener(mListener: ItemClickListener?) {
        listener = mListener
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }*/
}