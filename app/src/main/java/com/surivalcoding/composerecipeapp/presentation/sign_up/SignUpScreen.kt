package com.surivalcoding.composerecipeapp.presentation.sign_up


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.InputField
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

data class SignUpState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val acceptTerms: Boolean = false
)

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onTermsChange: (Boolean) -> Unit,
    onSignUpClick: () -> Unit,
    onGoogleSignUpClick: () -> Unit,
    onFacebookSignUpClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(20.dp)  // 기본 간격 수정
    ) {
        Spacer(modifier = Modifier.height(10.dp))  // 상단 여백 증가

        // 헤더 섹션
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)  // 헤더 텍스트 간격 증가
        ) {
            Text(
                text = "Create an account",
                style = AppTextStyles.normalTextBold
            )
            Text(
                text = "Let's help you set up your account,\nIt won't take long.",
                style = AppTextStyles.normalTextRegular
            )
        }

        // 입력 필드 섹션
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)  // 입력 필드간 간격
        ) {
            InputField(
                label = "Name",
                value = "",
                placeHolder = "Enter Name",
                onValueChange = onNameChange,
            )

            InputField(
                label = "Email",
                value = "",
                placeHolder = "Enter Email",
                onValueChange = onEmailChange
            )

            InputField(
                label = "Password",
                value = "",
                placeHolder = "Enter Password",
                onValueChange = onPasswordChange
            )

            InputField(
                label = "Confirm Password",
                value = "",
                placeHolder = "Retype Password",
                onValueChange = onConfirmPasswordChange
            )
        }

        // Terms & Conditions
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp)
                .clickable { onTermsChange },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CustomCheckbox(
                checked = false,
                onCheckedChange = onTermsChange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Accept terms & Condition",
                style = AppTextStyles.normalTextRegular.copy(
                    color = AppColors.secondary100
                )
            )
        }

        // Sign Up 버튼
        BigButton(
            text = "Sign Up",
            onClick = onSignUpClick,
        )

        // Or sign up with
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
                    style = AppTextStyles.normalTextRegular.copy(
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
                            .clickable(onClick = onGoogleSignUpClick),
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
                            .clickable(onClick = onFacebookSignUpClick),
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

        // 로그인 링크
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 32.dp)
                .clickable(onClick = onSignInClick),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already a member? ",
                style = AppTextStyles.normalTextSemiBold
            )
            Text(
                text = "Sign in",
                style = AppTextStyles.normalTextSemiBold.copy(
                    color = AppColors.secondary100
                )
            )
        }
    }
}

@Composable
fun CustomCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(17.dp)
            .border(
                width = 1.dp,
                color = AppColors.secondary100,
                shape = RoundedCornerShape(4.dp)
            )
            .background(
                color = if (checked) AppColors.secondary100 else Color.Transparent,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable { onCheckedChange(!checked) },
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Checked",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    device = "spec:width=375dp,height=812dp",
)
@Composable
private fun SignUpScreenPreview() {
//    SignUp(
//        state = SignUpState(),
//        onNameChange = { },
//        onEmailChange = { },
//        onPasswordChange = { },
//        onConfirmPasswordChange = { },
//        onTermsChange = { },
//        onSignUpClick = { },
//        onGoogleSignUpClick = { },
//        onFacebookSignUpClick = { },
//        onSignInClick = { }
//    )
}