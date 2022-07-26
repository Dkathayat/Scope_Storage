package com.example.lacknerstorage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lacknerstorage.databinding.ActivityMain2Binding
import java.io.File

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fileName = "My File"
        val fileContents = "Hello World!"
        openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(fileContents.toByteArray())

            binding.testText2.text =

                openFileInput(fileName).bufferedReader().useLines { lines ->
                    lines.fold("") { some, text ->
                        "$some\n$text"
                    }
                }.toString()
        }
    }
}