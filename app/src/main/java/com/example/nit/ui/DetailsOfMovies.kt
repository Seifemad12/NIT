package com.example.nit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.nit.Models.CategoriesModel
import com.example.nit.R

class detailsOfMovies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_of_movies)

        var moviesData= arrayListOf<String>()
        val movie=intent.getSerializableExtra("movie") as CategoriesModel
        for(i in 0..movie.listOfMovie.size-1){
            moviesData.add("Name: "+movie.listOfMovie[i].name+"\n\n"+"Description: \n"+movie.listOfMovie[i].description+"\n\n")
        }
        val mylist:ListView=findViewById(R.id.detail_list)
        var adpt=ArrayAdapter(this,android.R.layout.simple_list_item_1,moviesData)
        mylist.adapter= adpt


    }
}