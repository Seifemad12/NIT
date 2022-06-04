package com.example.nit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.nit.Data.JsonFileEditor
import com.example.nit.Models.CategoriesModel
import com.example.nit.Models.MovieDataModel
import com.example.nit.R
import java.io.InputStream
import java.util.HashMap

class AllMoviesCategories : AppCompatActivity() {
    var moviearray= arrayListOf<String>()
    var map: MutableMap<String, CategoriesModel> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_movies_categories)

        val mytext: ListView =findViewById(R.id.my_list)

        val input: InputStream = assets.open("movies-data.json")
        moviearray= JsonFileEditor().GetAllMovieDetails(map,input)
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, moviearray)
        mytext.adapter = adapter
        mytext.setOnItemClickListener { parent, view, position, id ->
            var selectedCategory=moviearray[position]
            val intent = Intent(this, detailsOfMovies::class.java)
            intent.putExtra("movie",map[selectedCategory])
            startActivity(intent)
        }
    }
}