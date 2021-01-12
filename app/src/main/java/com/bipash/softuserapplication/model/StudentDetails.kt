package com.bipash.softuserapplication.model

import java.io.Serializable

data class StudentDetails (
        var gender : String ?= null,
        var fullName : String ?= null,
        var age : String ?= null,
        var address : String ?= null
        ):Serializable