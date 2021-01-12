package com.bipash.softuserapplication.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bipash.softuserapplication.Database
import com.bipash.softuserapplication.R
import com.bipash.softuserapplication.model.StudentDetails

private var database = Database()
private var studentList = arrayListOf<StudentDetails>()
class studentDetailsAdapter (
    val context : Context
    ) : RecyclerView.Adapter<studentDetailsAdapter.StudentViewHolder>(){
    class StudentViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val imgProfile : ImageView
        val tvName : TextView
        val tvAge : TextView
        val tvAddress : TextView
        val tvGender : TextView
        val delete : ImageView
        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            delete = view.findViewById(R.id.delete)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): studentDetailsAdapter.StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_layout,parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: studentDetailsAdapter.StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.tvName.text = student.fullName
        holder.tvAge.text = student.age
        holder.tvGender.text = student.gender
        holder.tvAddress.text = student.address
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

}