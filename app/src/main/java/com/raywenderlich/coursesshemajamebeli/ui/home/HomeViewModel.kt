package com.raywenderlich.coursesshemajamebeli.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.coursesshemajamebeli.model.Course
import com.raywenderlich.coursesshemajamebeli.model.Topic
import com.raywenderlich.coursesshemajamebeli.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {


    private var _topic = MutableLiveData<List<Topic>>()

    val topic: LiveData<List<Topic>> get() = _topic

    private var _course = MutableLiveData<List<Course>>()

    val course: LiveData<List<Course>> get() = _course

    fun loadData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val data = ApiService.dataService.getData()
                _topic.postValue(data.body()?.topic)
                _course.postValue(data.body()?.courses)
            }
        }
    }


}