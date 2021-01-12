package com.bipash.softuserapplication.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bipash.softuserapplication.MainActivity
import com.bipash.softuserapplication.R
import com.bipash.softuserapplication.model.StudentDetails

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var studentDetails : ArrayList<StudentDetails>
    var gender = ""

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        val etFullName : EditText = root.findViewById(R.id.etFullName)
        val etAge : EditText = root.findViewById(R.id.etAge)
        val etAddress : EditText = root.findViewById(R.id.etAddress)
        val rdoGroup : RadioGroup = root.findViewById(R.id.rdoGroup)
        val btnSubmit : Button = root.findViewById(R.id.btnSubmit)

        rdoGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.rdoMale->{
                        gender = "male"
                    }
                    R.id.rdoFemale->{
                        gender = "Female"
                    }
                    R.id.rdoOthers->{
                        gender = "Others"
                    }
                }
            }
        })

        btnSubmit.setOnClickListener{
            var studentDetails = StudentDetails(gender, etFullName.toString(), etAge.toString(), etAddress.toString())
            val intent = Intent()
            intent.putExtra("details", studentDetails)
            startActivity(intent)
        }


        return root
    }


}