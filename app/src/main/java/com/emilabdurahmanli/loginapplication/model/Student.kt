package com.emilabdurahmanli.loginapplication.model

import java.io.Serializable

data class Student (var id : String, var name : String, var surname : String, var age : String, var username : String, var password : String, var groupname : String, var right : String) : Serializable
