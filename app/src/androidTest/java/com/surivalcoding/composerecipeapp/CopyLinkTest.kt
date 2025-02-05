package com.surivalcoding.composerecipeapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.surivalcoding.composerecipeapp.presentation.item.dialog.RecipeLinkDialog
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RecipeDetailTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCopyLink() {
        // Context 가져온 후 ClipboardManager 가져오기
        val context = ApplicationProvider.getApplicationContext<Context>()
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        composeTestRule.setContent {
            RecipeLinkDialog(
                recipeId = 1,
                onCopyLink = { link ->
                    val clip = ClipData.newPlainText("Recipe Link", link)
                    clipboard.setPrimaryClip(clip)
                }
            )
        }

        // 링크 복사 버튼 클릭 수행(Copy Link 이름을 가진 버튼 클릭)
        composeTestRule.onNodeWithText("Copy Link").performClick()


        // 클립보드에 복사가 되었는지 검증 하기
        assert(clipboard.hasPrimaryClip())
        assertEquals("app.Recipe.co/1", clipboard.primaryClip?.getItemAt(0)?.text.toString())

    }
}






