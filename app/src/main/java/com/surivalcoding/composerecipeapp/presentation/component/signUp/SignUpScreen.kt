package com.surivalcoding.composerecipeapp.presentation.component.signUp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    Column {
        Box {
            // Create an account
        }
        Box {
            // let's ~
            Text("hello")
        }
        Box {
            // it won't
            Text("what")
        }

        Box {
            // name
        }
        Box {
            // 입력 창
        }
        Box {
            // Email
        }
        Box {
            // 입력 창
        }
        Box {
            // password
        }
        Box {
            // 입력 창
        }
        Box {
            // Confirm Password
        }
        Box {
            // 입력 창
        }
        Row {
            Box {
                // 체크 박스
            }
            Box {
                // Accept terms & Condition
            }
        }
        Box {
            // sign Up Button
        }
        Box {
            // 회색 줄
        }
        Row {
            Box {
                // 구글 이미지 창
            }
            Box {
                // 페이스 북 이미지 창
            }
        }
        Row {
            Box {
                // Already a member?
            }
            Box {
                // Sign in link
            }
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {

}