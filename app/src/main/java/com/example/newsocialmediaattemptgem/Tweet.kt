package com.example.newsocialmediaattemptgem

data class Tweet(
    val text: String = "",
    val userId: String = "",
    val timestamp: Long = 0,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)