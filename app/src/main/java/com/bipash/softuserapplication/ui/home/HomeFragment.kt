package com.bipash.softuserapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bipash.softuserapplication.R
import com.bipash.softuserapplication.adapter.studentDetailsAdapter
import com.bipash.softuserapplication.model.StudentDetails

class HomeFragment : Fragment() {

    private var layoutManager : RecyclerView.LayoutManager ?= null
    private var adapter:RecyclerView.Adapter<studentDetailsAdapter.StudentViewHolder>?=null
    private lateinit var details : RecyclerView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        details = root.findViewById(R.id.recyclerView)

        return root
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        details.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = studentDetailsAdapter(context)
        }
    }
}