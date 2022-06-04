package com.example.nit.Models

import java.io.Serializable

data class CategoriesModel(val id:Int, val name:String, val listOfMovie:ArrayList<MovieDataModel>):Serializable
