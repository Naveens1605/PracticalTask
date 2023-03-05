package com.example.practicaltask.utils.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaltask.data.Post
import com.example.practicaltask.databinding.ItemPostBinding

class PostAdapter(private val postList: List<Post>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(private val itemPostBinding: ItemPostBinding): RecyclerView.ViewHolder(itemPostBinding.root) {
        fun bind(post: Post) {
            itemPostBinding.post = post

            if(post.posttype == 2) {
                itemPostBinding.postVideo.setVideoPath(post.content)
                itemPostBinding.postVideo.seekTo(1)
            }

            itemPostBinding.playBtn.setOnClickListener {
                itemPostBinding.postVideo.start()
                itemPostBinding.playBtn.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}