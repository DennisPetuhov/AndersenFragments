package com.example.andersenfragments.Presenter

import androidx.lifecycle.ViewModel
import com.example.andersenfragments.Data.Cat
import com.example.andersenfragments.Data.CatRepository

class SharedViewModel : ViewModel() {


    private val catRepository = CatRepository()

    fun getCats(): List<Cat> {
        return catRepository.listCat

    }

}