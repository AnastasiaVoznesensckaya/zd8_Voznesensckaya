package com.example.praktika8

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {
    val tasks= mutableListOf<Tasks>()
    var i:Int=1
    init {
        while (i<=10){
            val task=Tasks(i,"TITLE","00.00.00","00:00","TEXT")
            tasks.add(task)
            i++
        }
    }
}