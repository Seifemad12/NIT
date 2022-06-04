package com.example.nit.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.nit.Models.CategoriesModel
import com.example.nit.Models.MovieDataModel
import com.example.nit.R
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.nio.file.Files
import java.nio.file.StandardOpenOption
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val allCatoegory:Button=findViewById(R.id.ViewAll)
        allCatoegory.setOnClickListener{
            val i = Intent(this, AllMoviesCategories::class.java)
            startActivity(i)
        }
    }
}