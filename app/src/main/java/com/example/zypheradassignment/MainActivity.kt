package com.example.zypheradassignment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.zypheradassignment.Api.ApiResponse
import com.example.zypheradassignment.Api.RetrofitInstanceClass
import com.example.zypheradassignment.Repository.RepositoryCallPost
import com.example.zypheradassignment.SwipableDialog.SwipableDialogClass
import com.example.zypheradassignment.ViewModel.MainViewModelFactory
import com.example.zypheradassignment.ViewModel.ViewModelClass
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {

    lateinit var uploadedImageView:ImageView
    private lateinit var viewModel: ViewModelClass
    lateinit var imageUri :Uri
    private lateinit var title:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title=findViewById(R.id.TitleEditText)
        val uploadImage:Button=findViewById(R.id.UploadImage)
        val showDataInDialog:Button=findViewById(R.id.ShowData)
        val uploadDataandCallApi:Button=findViewById(R.id.UploadData)

        uploadDataandCallApi.setOnClickListener {
            val repositoryCallPost=RepositoryCallPost()
            val viewModelFactory=MainViewModelFactory(repositoryCallPost)
        }

        uploadedImageView=findViewById(R.id.UploadedImage)
        uploadImage.setOnClickListener {
            uplaodImage()

        }

        showDataInDialog.setOnClickListener {
           SwipableDialogClass.CreateDialog(this)
        }
    }

    fun uplaodImage() {
       val intent=Intent()
       intent.setType("image/*")
       intent.setAction(Intent.ACTION_PICK)
       startActivityForResult(intent,200)
   }

//    suspend fun sendDataToApi() {
//        val call= RetrofitInstanceClass.apiService.CallPost(title.text.toString(),imageUri)
//        call.enqueue(object : Callback<ApiResponse?> {
//            fun onResponse(call: Call<ApiResponse?>?, response: Response<ApiResponse?>) {
//                SwipableDialogClass.CreateDialog(this@MainActivity)
//                val dialogTitle:TextView=findViewById(R.id.TvTitleDialog)
//                val dialogImage:ImageView=findViewById(R.id.ImgDialog)
//                dialogTitle.text=title.text.toString()
//                dialogImage.setImageURI(imageUri)
//            }
//
//            fun onFailure(call: Call<ApiResponse?>?, t: Throwable) {
//            }
//        })
//    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== RESULT_OK && requestCode==200){
            val imageUri=data?.data
            uploadedImageView.setImageURI(imageUri)
        }
    }

}