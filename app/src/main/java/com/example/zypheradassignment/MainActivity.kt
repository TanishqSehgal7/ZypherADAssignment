package com.example.zypheradassignment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.zypheradassignment.Repository.RepositoryCallPost
import com.example.zypheradassignment.SwipableDialog.SwipableDialogClass
import com.example.zypheradassignment.ViewModel.MainViewModelFactory
import com.example.zypheradassignment.ViewModel.ViewModelClass


class MainActivity : AppCompatActivity() {

    lateinit var uploadedImageView:ImageView
    private lateinit var viewModel: ViewModelClass
    lateinit var imageUri :Uri
    private lateinit var title:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageUri=Uri.parse("")
        title=findViewById(R.id.TitleEditText)
        val uploadImage:Button=findViewById(R.id.UploadImage)
//        val showDataInDialog:Button=findViewById(R.id.ndShowData)
        val uploadDataandCallApi:Button=findViewById(R.id.UploadData)
        val responseText:TextView=findViewById(R.id.responseText)

        uploadDataandCallApi.setOnClickListener {
            val repositoryCallPost=RepositoryCallPost()
            val viewModelFactory=MainViewModelFactory(repositoryCallPost)
            viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelClass::class.java)
            viewModel.CallPostFromViewModel(this.title.text.toString(), imageUri)
                viewModel.myResponse.observe(this, Observer { response ->
                    if (response.isSuccessful) {
//                        SwipableDialogClass.CreateDialog(this,response.body()?.dialogBoxTitle!!, response.body()!!.dialogBoxImage)
                        responseText.text="Response Code: "+response.code().toString() + "\n" +
                                "Response Body: "+ response.body()?.dialogBoxTitle
                        Toast.makeText(this, "Data send to Api Successfully", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        uploadedImageView=findViewById(R.id.UploadedImage)
        uploadImage.setOnClickListener {
            val intent=Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_PICK)
            startActivityForResult(intent,200)
        }
    }

//    fun uplaodImage() {
//       val intent=Intent()
//       intent.setType("image/*")
//       intent.setAction(Intent.ACTION_PICK)
//       startActivityForResult(intent,200)
//   }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== RESULT_OK && requestCode==200){
            val imageUri=data?.data
            uploadedImageView.setImageURI(imageUri)
        }
    }

}