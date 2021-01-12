package com.bipash.softuserapplication

import com.bipash.softuserapplication.model.StudentDetails

var studentList = arrayListOf<StudentDetails>()
class Database {
    fun appendStudent(studentDetails: StudentDetails){
        studentList.add(studentDetails)
    }
    fun returnStudent():ArrayList<StudentDetails>{
        return studentList
    }
    fun deleteStudent(studentDetails: StudentDetails){
        studentList.remove(studentDetails)
    }
}