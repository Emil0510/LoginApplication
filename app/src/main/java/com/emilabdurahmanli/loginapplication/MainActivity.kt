package com.emilabdurahmanli.loginapplication


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.emilabdurahmanli.loginapplication.databinding.ActivityMainBinding
import com.emilabdurahmanli.loginapplication.model.Student
import com.emilabdurahmanli.loginapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.logInBtn.setOnClickListener {
            checkUser()
        }
    }
    fun checkUser(){
        val call: Call<List<Student?>?>? = RetrofitClient.getRetrofitInstance()?.getApi()?.checkUser(binding.eTUserName.text.toString(), binding.eTPassword.text.toString())
        call?.enqueue(object : Callback<List<Student?>?> {
            override fun onResponse(call: Call<List<Student?>?>?, response: Response<List<Student?>?>) {
                val student: List<Student> = response.body() as List<Student>
                val intent = Intent(this@MainActivity, StudentActivity::class.java)
                intent.putExtra("Student", student[0])
                startActivity(intent)
            }

            override fun onFailure(call: Call<List<Student?>?>?, t: Throwable?) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}