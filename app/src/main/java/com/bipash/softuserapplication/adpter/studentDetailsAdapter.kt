package com.bipash.softuserapplication.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bipash.softuserapplication.R
import com.bipash.softuserapplication.model.StudentDetails

class studentDetailsAdapter (
    val context : Context,
    val studentlist : ArrayList<StudentDetails>
    ) : RecyclerView.Adapter<studentDetailsAdapter.StudentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentlist[position]
        holder.tvName.text = student.fullName
        holder.tvAddress.text = student.address
        holder.tvAge.text = student.age
        holder.tvGender.text = student.gender
    }

    override fun getItemCount(): Int {
        return studentlist.size
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProfile : ImageView = itemView.findViewById(R.id.imgProfile)
        val tvName : TextView = itemView.findViewById(R.id.tvName)
        val tvAge : TextView = itemView.findViewById(R.id.tvAddress)
        val tvAddress: TextView = itemView.findViewById(R.id.tvAge)
        val tvGender: TextView = itemView.findViewById(R.id.tvGender)
    }
}