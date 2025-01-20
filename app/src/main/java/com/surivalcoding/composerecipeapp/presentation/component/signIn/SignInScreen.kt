package com.surivalcoding.composerecipeapp.presentation.component.signIn

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.makeInputField
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
    val googleLogoUrl = "https://cdn.dribbble.com/userupload/8042382/file/still-d7480bc1d0cc72e418d20a4228c832da.png?resize=400x0"
    val facebookLogoUrl = "https://assets.st-note.com/production/uploads/images/117172649/rectangle_large_type_2_6d73a390d7a6993879eb09a8999bb4bc.png?fit=bounds&quality=85&width=1280"
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier
            .weight(0.12f))
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

        Spacer(modifier = Modifier
            .weight(0.02f))

        Row(modifier = Modifier
            .weight(0.02f)
            .fillMaxWidth(1f)) {
            Spacer(modifier = Modifier
                .weight(0.15f))
            Box(modifier = Modifier
                .weight(0.25f)) {
                Text(text = "Forget Password?", fontSize = 11.sp, color = AppColors.goldyello)
            }
            Spacer(modifier = Modifier
                .weight(0.63f))
        }

        Spacer(modifier = Modifier
            .weight(0.03f))

        Box(modifier = Modifier
            .weight(0.07f)) {
            BigButton(title = "Sign In")
        }

        Spacer(modifier = Modifier
            .weight(0.02f))

        Row(modifier = Modifier
            .weight(0.02f)
            .fillMaxWidth(1f),
            verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier
                .weight(0.24f))
            Box(modifier = Modifier
                .weight(0.13f)) {
                Divider(thickness = 1.dp, color = AppColors.gray_04)
            }
            Spacer(modifier = Modifier
                .weight(0.02f))
            Box(modifier = Modifier
                .wrapContentWidth()) {
                Text(text = "Or Sign in With", fontSize = 11.sp, textAlign = TextAlign.Center, color = AppColors.gray_04)
            }
            Spacer(modifier = Modifier
                .weight(0.02f))
            Box(modifier = Modifier
                .weight(0.13f)) {
                Divider(thickness = 1.dp, color = AppColors.gray_04)
            }
            Spacer(modifier = Modifier
                .weight(0.24f))
        }

        Spacer(modifier = Modifier
            .weight(0.02f))

        Row(modifier = Modifier
            .weight(0.06f)
            .fillMaxWidth(1f)) {
            Spacer(modifier = Modifier
                .weight(0.35f))

            AsyncImage(
                model = if(LocalInspectionMode.current) {
                    ColorDrawable(Color.Red.toArgb())
                } else {
                    R.drawable.google_logo
                },
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .weight(0.14f),
                contentDescription = null
            )
            Spacer(modifier = Modifier
                .weight(0.04f))

            AsyncImage(
                model = if(LocalInspectionMode.current) {
                    ColorDrawable(Color.Blue.toArgb())
                } else {
                    R.drawable.facebook_logo
                },
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .weight(0.14f),
                contentDescription = null
            )
            Spacer(modifier = Modifier
                .weight(0.35f))
        }

        Spacer(modifier = Modifier
            .weight(0.06f))

        Row(modifier = Modifier
            .weight(0.02f)) {
            Box {
                Text(text = "Don't have an account? ", fontSize = 11.sp)
            }
            Box {
                Text(text = "Sign up", fontSize = 11.sp, color = AppColors.goldyello)
            }
        }
        Spacer(modifier = Modifier
            .weight(0.1f))
    }
}

@Preview(showBackground = true)
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}