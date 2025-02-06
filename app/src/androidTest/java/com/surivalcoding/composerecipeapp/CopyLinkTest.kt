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

    // Context 가져오기
    private val context: Context by lazy {
        ApplicationProvider.getApplicationContext()
    }

    // ClipboardManager
    private val clipboardManager: ClipboardManager by lazy {
        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    // createComposeRule()은 내부적으로 ComponentActivity를 시작 시킴 -> 따라서 setContent로 컴포저블 함수 지정 가능
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCopyLink() {

        composeTestRule.setContent {
            RecipeLinkDialog(
                recipeId = 1,
                onCopyLink = { link ->
                    val clip = ClipData.newPlainText("Recipe Link", link)
                    clipboardManager.setPrimaryClip(clip)
                }
            )
        }

        // 링크 복사 버튼 클릭 수행(Copy Link 이름을 가진 버튼 클릭)
        composeTestRule.onNodeWithText("Copy Link").performClick()


        // 클립보드에 복사가 되었는지 검증 하기
        assert(clipboardManager.hasPrimaryClip())
        assertEquals("app.Recipe.co/1", clipboardManager.primaryClip?.getItemAt(0)?.text.toString())

    }
}






