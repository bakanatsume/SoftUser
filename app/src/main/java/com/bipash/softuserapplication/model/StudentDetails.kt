package com.bipash.softuserapplication.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class StudentDetails (
        var gender : String ?= null,
        var fullName : String ?= null,
        var age : String ?= null,
        var address : String ?= null
        ):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun describeContents(): Int {
                TODO("Not yet implemented")
        }

        override fun writeToParcel(dest: Parcel?, flags: Int) {
                TODO("Not yet implemented")
        }

        companion object CREATOR : Parcelable.Creator<StudentDetails> {
                override fun createFromParcel(parcel: Parcel): StudentDetails {
                        return StudentDetails(parcel)
                }

                override fun newArray(size: Int): Array<StudentDetails?> {
                        return arrayOfNulls(size)
                }
        }
}