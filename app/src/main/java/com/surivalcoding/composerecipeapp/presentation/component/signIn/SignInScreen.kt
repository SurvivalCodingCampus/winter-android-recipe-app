package com.surivalcoding.composerecipeapp.presentation.component.signIn

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.makeInputField

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier
            .weight(0.11f))
        Row(modifier = Modifier
            .weight(0.08f)
            .fillMaxWidth(1f)) {
            Spacer(modifier = Modifier
                .weight(0.08f))
            Column(modifier = Modifier
                .weight(0.35f)) {
                Text(text = "Hello", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Text(text = "Welcome Back!", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier
                .weight(0.5f))
        }
        Spacer(modifier = Modifier
            .weight(0.07f))
        Box(modifier = Modifier
            .weight(0.1f)) {
            makeInputField(title = "Email", placeholder = "Enter Email")
        }
        Spacer(modifier = Modifier
            .weight(0.03f))
        Box(modifier = Modifier
            .weight(0.1f)) {
            makeInputField(title = "Enter Password", placeholder = "Enter Password")
        }
        Row(modifier = Modifier
            .weight(0.02f)
            .fillMaxWidth(1f)) {
            Spacer(modifier = Modifier
                .weight(0.15f))
            Box(modifier = Modifier
                .weight(0.25f)) {
                Text(text = "Forget Password?", fontSize = 11.sp)
            }
            Spacer(modifier = Modifier
                .weight(0.63f))
        }
        Spacer(modifier = Modifier
            .weight(0.03f))
        Box(modifier = Modifier
            .weight(0.07f)) {
            BigButton(text = "Sign In")
        }
        Box {
            // 회색 줄
        }
        Row {
            Box {
                // 구글 이미지 버튼
            }
            Box {
                // 페이스북 이미지 버튼
            }
        }
        Row {
            Box {
                // don't you have an account?
            }
            Box {
                // sign up
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}