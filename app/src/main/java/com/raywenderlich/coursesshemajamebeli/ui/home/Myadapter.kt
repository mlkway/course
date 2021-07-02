package com.raywenderlich.coursesshemajamebeli.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.coursesshemajamebeli.R
import com.raywenderlich.coursesshemajamebeli.databinding.CoursItemBinding
import com.raywenderlich.coursesshemajamebeli.model.Course
import com.raywenderlich.coursesshemajamebeli.model.Topic

class Myadapter:RecyclerView.Adapter<Myadapter.ViewHolder>() {

    var data: List<Topic> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter.ViewHolder {
        return ViewHolder(CoursItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Myadapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()= data.size

    inner class ViewHolder(private val binding: CoursItemBinding):RecyclerView.ViewHolder(binding.root){
        private lateinit var current: Topic
        fun bind(){
            current = data[adapterPosition]
               binding.root.setBackgroundColor(Color.parseColor("#${current.color}"))
              binding.title.text = current.title
                if (current.type == "free"){
                    binding.icon.setImageResource(R.drawable.ic_realsetting)
                }else{
                    binding.icon.setImageResource(R.drawable.ic_bank_card)
                }

            binding.duration.text = current.duration.toString() + "min"




        }
    }

}