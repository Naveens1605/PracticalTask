package com.example.practicaltask.ui.home

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicaltask.data.Post
import com.example.practicaltask.repo.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel(), LifecycleObserver {

    private val _postPost = MutableLiveData<List<Post>>()
    val postData = _postPost

   init {
       viewModelScope.launch(Dispatchers.IO) {
           postRepository.getAllPosts { response, failure ->
                if (failure == null) _postPost.postValue(response)
           }
       }
   }
}