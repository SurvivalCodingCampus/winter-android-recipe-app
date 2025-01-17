package com.surivalcoding.composerecipeapp.presentation.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.InputField
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SignIn(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignInClick: (String, String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    onFacebookSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(20.dp)  // 기본 간격 증가
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        // 헤더 섹션
        Column {
            Text(
                text = "Hello,",
                style = AppTextStyles.headerTextBold
            )
            Text(
                text = "Welcome Back!",
                style = AppTextStyles.largeTextRegular
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 입력 필드 섹션
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp)  // 입력 필드 간 간격
        ) {
            InputField(
                label = "Email",
                value = email,
                placeholder = "Enter Email",
                onValueChange = onEmailChange
            )

            InputField(
                label = "Enter Password",
                value = password,
                placeholder = "Enter Password",
                onValueChange = onPasswordChange
            )
        }

        // Forgot Password
        Text(
            text = "Forgot Password?",
            style = AppTextStyles.smallerTextRegular.copy(
                color = AppColors.secondary100
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 12.dp, bottom = 4.dp)
                .clickable { onForgotPasswordClick() }
        )

        // 로그인 버튼
        BigButton(
            buttonText = "Sign In",
            onClick = { onSignInClick(email, password) }
        )

        // Or sign in with
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 60.dp),
                    color = AppColors.gray4,
                    thickness = 1.dp
                )
                Text(
                    text = "Or sign in with",
                    style = AppTextStyles.smallerTextRegular.copy(
                        color = AppColors.gray3
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 60.dp),
                    color = AppColors.gray4,
                    thickness = 1.dp
                )
            }

            // 소셜 로그인 버튼
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                // 구글 로그인
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .shadow(
                                elevation = 5.dp,  // 그림자 크기 증가
                                shape = RoundedCornerShape(10.dp),
                                spotColor = AppColors.black.copy(alpha = 0.5f),
                                ambientColor = AppColors.black.copy(alpha = 0.5f),
                                clip = false
                            )
                            .size(44.dp)
                            .background(
                                color = AppColors.white,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable(onClick = onGoogleSignInClick),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "Google Sign In",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                // 페이스북 로그인
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .shadow(
                                elevation = 5.dp,  // 그림자 크기 증가
                                shape = RoundedCornerShape(10.dp),
                                spotColor = AppColors.black.copy(alpha = 0.5f),
                                ambientColor = AppColors.black.copy(alpha = 0.5f),
                                clip = false
                            )
                            .size(44.dp)
                            .background(
                                color = AppColors.white,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable(onClick = onFacebookSignInClick),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "Facebook Sign In",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 회원가입 링크
        FlowRow( // 200% scale에서 SignUp이 세로로 넘어가도록 수정
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onSignUpClick),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have an account? ",
                style = AppTextStyles.smallerTextBold
            )
            Text(
                text = "Sign up",
                style = AppTextStyles.smallerTextBold.copy(
                    color = AppColors.secondary100
                )
            )
        }
    }
}


@Preview(
    showBackground = true,
    device = "spec:width=375dp,height=812dp",
)
@Composable
private fun SignInPreview() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    SignIn(
        email = email,
        password = password,
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        onSignInClick = { _, _ -> },
        onForgotPasswordClick = { },
        onGoogleSignInClick = { },
        onFacebookSignInClick = { },
        onSignUpClick = { }
    )
}