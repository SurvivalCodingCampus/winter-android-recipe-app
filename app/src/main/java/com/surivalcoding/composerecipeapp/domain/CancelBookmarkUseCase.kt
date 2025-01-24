package com.surivalcoding.composerecipeapp.domain

import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

class CancelBookmarkUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository,
) {
    suspend fun execute(id: Int = 0): List<Int> {
        return bookmarkRepository.cancelBookmarkId(id)
    }
}