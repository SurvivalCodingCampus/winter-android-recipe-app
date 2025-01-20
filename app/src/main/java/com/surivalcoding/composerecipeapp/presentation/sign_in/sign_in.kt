package com.surivalcoding.composerecipeapp.presentation.sign_in

import DividerWithText
import SocialLoginButton
import TextWithLink
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.button.BaseButton
import com.surivalcoding.composerecipeapp.presentation.component.text.CustomTextField
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SignInScreen(
    onSignInClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    onFacebookSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 30.dp, top = 94.dp, end = 30.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            Text(
                text = "Hello,",
                modifier = Modifier,
                style = AppTextStyles.boldHeader
            )
            Text(
                text = "Welcome back!",
                style = AppTextStyles.regularMedium
            )


            Box(
                modifier = Modifier.padding(top = 57.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically)
                ) {
                    CustomTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = "Name",
                        placeholder = "Enter Name"
                    )

                    CustomTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = "Enter Password",
                        placeholder = "Enter Password"
                    )

                    Text(
                        "Forgot Password?",
                        style = AppTextStyles.regularSmall,
                        color = AppColors.Secondary100,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable { onForgotPasswordClick() }  // 클릭 이벤트 추가
                    )

                    BaseButton(
                        modifier = Modifier.fillMaxWidth(),
                        width = 240.dp,
                        height = 60.dp,
                        text = "Sign In",
                        color = AppColors.Primary100,
                        fontStyle = AppTextStyles.boldNormal,
                        iconSize = 20.dp,
                        enabled = true,
                        onClick = onSignInClick  // 클릭 이벤트 추가
                    )

                    DividerWithText(text = "Or Sign in With")

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SocialLoginButton(
                            icon = R.drawable.icons_google,
                            onClick = onGoogleSignInClick  // 클릭 이벤트 추가
                        )

                        SocialLoginButton(
                            icon = R.drawable.facebook,
                            onClick = onFacebookSignInClick  // 클릭 이벤트 추가
                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        TextWithLink(
                            text = "Don't have an account?",
                            linkText = "Sign Up",
                            onClick = onSignUpClick  // 클릭 이벤트 추가
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SigninScreenPreview() {
    SignInScreen(
        onSignInClick = {},
        onForgotPasswordClick = {},
        onGoogleSignInClick = {},
        onFacebookSignInClick = {},
        onSignUpClick = {}
    )
}