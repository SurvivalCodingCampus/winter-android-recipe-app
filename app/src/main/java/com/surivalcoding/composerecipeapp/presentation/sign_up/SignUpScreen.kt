package com.surivalcoding.composerecipeapp.presentation.sign_up

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.InputField
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    state: SignUpState = SignUpState(),
    isFocused: Boolean = false,
    onValueChange: (String) -> Unit = {},
    onSignInClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onSignInWithGoogleClick: () -> Unit = {},
    onSignInWithFacebookClick: () -> Unit = {},
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
                    .padding(top = 54.dp),
            ) {
                Text(
                    text = "Create an account",
                    style = AppTextStyles.largeTextBold.copy(
                        color = AppColors.font,
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                )
                Text(
                    modifier = Modifier
                        .width(195.dp)
                        .height(34.dp),
                    text = "Let’s help you set up your account, it won’t take long.",
                    style = AppTextStyles.smallerTextRegular.copy(
                        color = AppColors.font,
                        fontSize = 11.sp,
                        lineHeight = 17.sp
                    )

                )
                InputField(
                    modifier = Modifier.padding(top = 20.dp),
                    label = "Name",
                    placeholder = "Enter Name",
                    value = "",
                    onValueChange = onValueChange
                )
                InputField(
                    modifier = Modifier.padding(top = 20.dp),
                    label = "Email",
                    placeholder = "Enter Email",
                    value = "",
                    onValueChange = onValueChange,
                )
                InputField(
                    modifier = Modifier.padding(top = 20.dp),
                    label = "Password",
                    placeholder = "Enter Password",
                    value = "",
                    onValueChange = onValueChange
                )
                InputField(
                    modifier = Modifier.padding(top = 20.dp),
                    label = "Confirm Password",
                    placeholder = "Retype Password",
                    value = "",
                    onValueChange = onValueChange
                )

                Row(
                    modifier = Modifier
                        .width(170.dp)
                        .padding(top = 20.dp, start = 9.dp),
                ) {
                    Button(
                        modifier = Modifier.size(17.dp),
                        onClick = onForgotPasswordClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent, // 필요 없으면 제거 가능
                            contentColor = AppColors.secondary100
                        ),
                        contentPadding = PaddingValues(0.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .size(15.dp)
                                .clip(RoundedCornerShape(5.dp)) // 모양을 강제
                                .background(Color.White) // 배경 적용
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFFF9C00),
                                    shape = RoundedCornerShape(5.dp) // 동일한 모양 유지
                                ),
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .width(4.dp)
                            .height(17.dp)
                    )

                    Button(
                        modifier = Modifier
                            .width(142.dp)
                            .height(17.dp),
                        onClick = onForgotPasswordClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = AppColors.secondary100
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            modifier = Modifier.height(142.dp),
                            text = "Accept terms & Condition",
                            style = AppTextStyles.smallerTextRegular.copy(
                                fontSize = 11.sp,
                                lineHeight = 17.sp
                            ),
                        )
                    }
                }

                BigButton(
                    modifier = Modifier.padding(top = 25.dp),
                    text = "Sign Up",
                    onClick = onSignUpClick,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 14.dp, start = 60.dp, end = 60.dp),
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
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(177.dp)
                        .height(17.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    Text(
                        text = "Already a member?",
                        style = AppTextStyles.smallerTextSemiBold.copy(
                            color = AppColors.black
                        ),
                    )
                    Button(
                        onClick = onSignInClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent, // 버튼의 배경색을 투명으로 설정
                            contentColor = AppColors.secondary100 // 텍스트 색상
                        ),
                        contentPadding = PaddingValues(0.dp) // contentPadding을 0으로 설정
                    ) {
                        Text(
                            modifier = Modifier.fillMaxHeight(),
                            text = "Sign In",
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
private fun SignUpScreenPreview() {
    var text1 by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        SignUpScreen(
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