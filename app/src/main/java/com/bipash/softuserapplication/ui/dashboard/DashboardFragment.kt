package com.bipash.softuserapplication.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bipash.softuserapplication.Database
import com.bipash.softuserapplication.MainActivity
import com.bipash.softuserapplication.R
import com.bipash.softuserapplication.model.StudentDetails
import org.w3c.dom.Text

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    var gender = ""

    private lateinit var etFullName : EditText
    private lateinit var etAge : EditText
    private lateinit var etAddress : EditText
    private lateinit var rdoGroup : RadioGroup
    private lateinit var btnSubmit : Button

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
        etFullName = root.findViewById(R.id.etFullName)
        etAge  = root.findViewById(R.id.etAge)
        etAddress  = root.findViewById(R.id.etAddress)
        rdoGroup = root.findViewById(R.id.rdoGroup)
        btnSubmit = root.findViewById(R.id.btnSubmit)

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
            if(err()){
                        var studentDetails = StudentDetails(gender, etFullName.text.toString(), etAge.text.toString(), etAddress.text.toString())
                        val database = Database()
                        database.appendStudent(studentDetails)
                    }
            clean()
            Toast.makeText(context, "Added Sucessfully", Toast.LENGTH_SHORT).show()
        }

        return root
    }

    private fun clean() {
        etFullName.setText(" ")
        etAddress.setText(" ")
        etAge.setText(" ")
    }

    private fun err():Boolean{
        var flag = true
        if(TextUtils.isEmpty(etFullName.text)){
            etFullName.error="Plese enter your username"
            etFullName.requestFocus()
            flag = false
        }
        else if (TextUtils.isEmpty(etAge.text)){
            etAge.error="PLease enter your valid age"
            etAge.requestFocus()
            flag = false
        }
        else if(TextUtils.isEmpty(etAddress.text)){
            etAddress.error="PLease enter your address"
            etAddress.requestFocus()
            flag = false
        }
        return flag
    }

}