package com.surivalcoding.composerecipeapp.domain.usecase

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CopyLinkUseCase @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun execute(link: String): Boolean {

        val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Recipe Link", link)
        clipBoard.setPrimaryClip(clip)

        return clipBoard.hasPrimaryClip() && clipBoard.primaryClip?.getItemAt(0)?.text == link
    }
}