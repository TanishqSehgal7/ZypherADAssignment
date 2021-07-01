package com.example.zypheradassignment.Model

import android.net.Uri
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataClass(
    @field:SerializedName("dialogBoxTitle")
    @Expose
    val dialogBoxTitle:String,
    @Expose
    @field:SerializedName("dialogBoxImage")
    val dialogBoxImage:Uri)