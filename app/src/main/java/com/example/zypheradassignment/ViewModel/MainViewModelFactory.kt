package com.example.zypheradassignment.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zypheradassignment.Repository.RepositoryCallPost

class MainViewModelFactory(private val repositoryCallPost: RepositoryCallPost): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelClass(repositoryCallPost) as T
    }
}