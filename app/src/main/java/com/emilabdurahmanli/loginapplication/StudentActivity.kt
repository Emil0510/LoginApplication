package com.emilabdurahmanli.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emilabdurahmanli.loginapplication.databinding.ActivityStudentBinding
import com.emilabdurahmanli.loginapplication.model.Student

class StudentActivity : AppCompatActivity() {
    lateinit var binding : ActivityStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val student : Student= intent.getSerializableExtra("Student") as Student
        binding.nameText.setText(student.name)
    }
}