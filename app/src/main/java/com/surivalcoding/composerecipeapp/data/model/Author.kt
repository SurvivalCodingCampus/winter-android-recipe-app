package org.example.day19.model

data class Author(
    val id: String,
    val name: String,
    val portraitUrl: String,
    val isUserFollowed: Boolean,
    val address: String
)