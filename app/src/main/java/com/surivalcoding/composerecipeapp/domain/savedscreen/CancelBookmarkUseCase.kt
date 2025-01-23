package com.surivalcoding.composerecipeapp.domain.savedscreen

import com.surivalcoding.composerecipeapp.data.repository.BookmarkRepository

class CancelBookmarkUseCase(
    private val bookmarkRepository: BookmarkRepository
) {
    suspend fun execute(id: Int = 0): List<Int> {
        return bookmarkRepository.cancelBookmarkId(id)
    }
}