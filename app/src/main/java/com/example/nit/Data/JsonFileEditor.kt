package com.example.nit.Data

import android.widget.ListView
import com.example.nit.Models.CategoriesModel
import com.example.nit.Models.MovieDataModel
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class JsonFileEditor {
    fun GetAllMovieDetails( map:MutableMap<String, CategoriesModel>, input: InputStream):ArrayList<String>{
        var movies_data=ArrayList<MovieDataModel>()

        var CategoriesNames=ArrayList<String>()
        var json:String?=null
        try {
            json = input.bufferedReader().use { it.readText() }
            var obj = JSONObject(json)
            var jsonArray = obj.getJSONArray("categories")
            for (i in 0..jsonArray.length() - 1) {
                movies_data=ArrayList<MovieDataModel>()
                var obj = jsonArray.getJSONObject(i)

                /*var m=obj.getString("movies")*/
                CategoriesNames.add(obj.getString("name"))

                var allmovies = obj.getJSONArray("movies")

                for (j in 0..allmovies.length() - 1) {
                    var movieDetails = allmovies.getJSONObject(j)
                    var id: Int = movieDetails.getInt("id")
                    var name: String = movieDetails.getString("name")
                    var description: String = movieDetails.getString("description")
                    var rate: Int = movieDetails.getInt("rate")
                    val movie = MovieDataModel(id, name, description, rate)
                    movies_data.add(movie)
                }
                var categories=CategoriesModel(obj.getInt("id"),obj.getString("name"),movies_data)
                map[obj.getString("name")] =categories


            }
        }
        catch (e: IOException){
        }
        return CategoriesNames
    }
}