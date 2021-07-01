package com.example.zypheradassignment.Repository

import android.net.Uri
import com.example.zypheradassignment.Api.RetrofitInstanceClass
import com.example.zypheradassignment.Model.DataClass
import retrofit2.Response

class RepositoryCallPost {

    suspend fun CallPost(title:String, image: Uri) :Response<DataClass> {
      return  RetrofitInstanceClass.apiService.CallPost(title,image)
    }

}