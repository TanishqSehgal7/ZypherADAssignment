package com.example.zypheradassignment.Interface

import android.net.Uri
import com.example.zypheradassignment.Model.DataClass
import retrofit2.Response
import retrofit2.http.*

interface ZypherApi {

    @POST("/testData")
    @FormUrlEncoded
    suspend fun CallPost(@Field("dialogBoxTitle") dialogBoxTitle: String, @Field("dialogBoxImage") dialogBoxImage: Uri) : Response<DataClass>

//    @GET("/testData")
//    suspend fun GetPost(@Query("dialogBoxTitle") dialogBoxTitle:String, @Query("dialogBoxImage") dialogBoxImage:Int)
}