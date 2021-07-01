package com.example.zypheradassignment.ViewModel

import android.icu.text.CaseMap
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zypheradassignment.Model.DataClass
import com.example.zypheradassignment.Repository.RepositoryCallPost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelClass(private val repositoryCallPost: RepositoryCallPost) : ViewModel() {

    var myResponse: MutableLiveData<Response<DataClass>> = MutableLiveData()

     fun CallPostFromViewModel(title: String, image: Uri) {
        viewModelScope.launch(Dispatchers.Default) {
            val response = repositoryCallPost.CallPost(title, image)
            myResponse.postValue(response)
        }
    }

}