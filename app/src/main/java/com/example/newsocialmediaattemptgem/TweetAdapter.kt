package com.example.newsocialmediaattemptgem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TweetAdapter(private val tweetList: List<Tweet>) : RecyclerView.Adapter<TweetAdapter.TweetViewHolder>() {

    class TweetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tweetText: TextView = itemView.findViewById(R.id.tweetText) // Replace with your TextView ID
        val userIdText: TextView = itemView.findViewById(R.id.userIdText) // Replace with your TextView ID
        // Add more TextViews for other tweet properties if needed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tweet_item, parent, false) // Replace with your item layout
        return TweetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val currentItem = tweetList[position]
        holder.tweetText.text = currentItem.text
        holder.userIdText.text = currentItem.userId
        // Bind other tweet properties to TextViews
    }

    override fun getItemCount() = tweetList.size
}