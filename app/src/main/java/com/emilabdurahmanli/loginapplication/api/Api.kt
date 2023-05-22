package com.emilabdurahmanli.loginapplication.api

import com.emilabdurahmanli.loginapplication.model.Student
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET("login.php")
    fun checkUser(@Query("username")username : String, @Query("password")password : String): Call<List<Student?>?>?
}