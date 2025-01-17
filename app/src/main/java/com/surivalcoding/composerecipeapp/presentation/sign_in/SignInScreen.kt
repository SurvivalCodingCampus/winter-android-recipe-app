package com.surivalcoding.composerecipeapp.presentation.sign_in

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.InputField
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    isFocused: Boolean,
    onValueChange: (String) -> Unit,
    onSignInClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onSignInWithGoogleClick: () -> Unit,
    onSignInWithFacebookClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box( // 내부 Column을 감싸는 Box
            modifier = Modifier
                .width(315.dp),
            contentAlignment = Alignment.TopStart // 좌측 상단 정렬
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 94.dp),
            ) {
                Text(
                    text = "Hello,",
                    style = AppTextStyles.headerTextBold.copy(
                        color = AppColors.font,
                    )
                )
                Text(
                    text = "Welcome Back!",
                    style = AppTextStyles.largeTextRegular.copy(
                        color = AppColors.font,
                    )
                )

                InputField(
                    modifier = Modifier.padding(top = 57.dp),
                    label = "Email",
                    placeholder = "Enter Email",
                    value = "",
                    onValueChange = onValueChange
                )
                InputField(
                    modifier = Modifier.padding(top = 30.dp),
                    label = "Enter Password",
                    placeholder = "Enter Password",
                    value = "",
                    onValueChange = onValueChange,
                )

                Button(
                    modifier = Modifier
                        .padding(top = 20.dp, start = 10.dp),
                    onClick = onForgotPasswordClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent, // 버튼의 배경색을 투명으로 설정
                        contentColor = AppColors.secondary100 // 텍스트 색상
                    ),
                    contentPadding = PaddingValues(0.dp) // contentPadding을 0으로 설정
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Forgot Password?",
                        style = AppTextStyles.smallerTextRegular.copy(
                            fontSize = 11.sp,
                            lineHeight = 17.sp
                        ),
                    )
                }
                BigButton(
                    modifier = Modifier.padding(top = 25.dp),
                    text = "Sign In",
                    onClick = onSignInClick,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 60.dp, end = 60.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    HorizontalDivider(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 7.dp),
                        color = AppColors.gray4
                    )
                    Text(
                        text = "Or sign in with",
                        modifier = Modifier,
                        style = AppTextStyles.smallerTextSemiBold.copy(
                            color = AppColors.gray4
                        ),
                    )
                    HorizontalDivider(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 7.dp),
                        color = AppColors.gray4
                    )
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        modifier = Modifier
                            .size(44.dp)
                            .shadow(
                                elevation = 5.dp,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .background(
                                color = AppColors.white,
                            ),
                        onClick = onSignInWithGoogleClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppColors.white,
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.google_icon8),
                            contentDescription = "Google Sign Up",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Unspecified // 아이콘의 색상을 원래 색상으로 설정
                        )
                    }
                    Spacer(modifier = Modifier.width(25.dp))
                    Button(
                        modifier = Modifier
                            .size(44.dp)
                            .shadow(
                                elevation = 5.dp,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .background(
                                color = AppColors.white,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        onClick = onSignInWithFacebookClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppColors.white,
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook_icon),
                            contentDescription = "Facebook Sign Up",
                            modifier = Modifier.size(44.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.padding(top = 55.dp)
                        .width(177.dp)
                        .height(17.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    Text(
                        text = "Don't have an account?",
                        style = AppTextStyles.smallerTextSemiBold.copy(
                            color = AppColors.black
                        ),
                    )
                    Button(
                        onClick = onSignUpClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent, // 버튼의 배경색을 투명으로 설정
                            contentColor = AppColors.secondary100 // 텍스트 색상
                        ),
                        contentPadding = PaddingValues(0.dp) // contentPadding을 0으로 설정
                    ) {
                        Text(
                            modifier = Modifier.fillMaxHeight(),
                            text = "Sign up",
                            style = AppTextStyles.smallerTextSemiBold,
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SignInScreenPreview() {
    var text1 by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        SignInScreen(
            isFocused = false,
            onValueChange = { text1 = it },
            onSignInClick = {},
            onForgotPasswordClick = {},
            onSignUpClick = {},
            onSignInWithGoogleClick = {},
            onSignInWithFacebookClick = {}
        )
    }
}