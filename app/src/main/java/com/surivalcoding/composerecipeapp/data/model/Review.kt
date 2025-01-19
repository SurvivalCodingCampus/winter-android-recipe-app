package org.example.day19.model
import java.time.LocalDateTime

data class Review(
    val id: String,
    val author: Author,
    val content: String,
    val rate: Int,
    val createdAt: LocalDateTime
)