package com.surivalcoding.composerecipeapp.presentation.sign_in

import AppColors
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.InputField
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSignInClicked: () -> Unit,
    onSocialSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .padding(horizontal = 30.dp, vertical = 50.dp)
    ) {
        Text(
            text = "Hello,", style = AppTextStyles.normalTextBold.copy(
                fontSize = 30.sp, color = AppColors.font
            )
        )
        Text(
            text = "Welcome Back!", style = AppTextStyles.normalTextRegular.copy(
                fontSize = 20.sp, color = AppColors.font
            )
        )

        Spacer(modifier.height(57.dp))
        InputField(modifier = Modifier,
            label = "Email",
            placeHolder = "Enter Email",
            value = "",
            onValueChange = {})

        Spacer(modifier.height(30.dp))

        InputField(modifier = Modifier,
            label = "Enter Password",
            placeHolder = "Enter Password",
            value = "",
            onValueChange = {})
        Spacer(modifier.height(20.dp))

        Text(
            modifier = modifier.padding(start = 10.dp),
            text = "Forgot Password?",
            style = AppTextStyles.normalTextRegular.copy(
                fontSize = 11.sp, color = AppColors.secondary100
            )
        )

        Spacer(modifier.height(25.dp))
        BigButton(text = "Sign In")
        Spacer(modifier.height(20.dp))

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 왼쪽 Divider
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp), color = AppColors.gray4
            )

            // 텍스트
            Text(
                modifier = Modifier.padding(horizontal = 7.dp),
                text = "Or Sign in With",
                style = AppTextStyles.normalTextSemiBold
            )

            // 오른쪽 Divider
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp), color = AppColors.gray4
            )


        }

        Spacer(modifier.height(20.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {


            SocialButton(
                iconRes = R.drawable.ic_google
            )
            Spacer(modifier.width(20.dp))
            SocialButton(
                iconRes = R.drawable.ic_facebook
            )
        }

        Spacer(modifier.height(55.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Don't have an account?",
                style = AppTextStyles.normalTextSemiBold.copy(
                    color = AppColors.font
                )
            )
            Text(
                modifier = modifier.padding(start = 5.dp)
                    .clickable(onClick = onSignUpClicked),
                text = "Sign Up",
                style = AppTextStyles.normalTextSemiBold.copy(
                    color = AppColors.secondary100
                ),

            )

        }
    }
}

@Composable
fun SocialButton(iconRes: Int) {
    Card(
        modifier = Modifier.size(44.dp), // Card의 크기를 설정
        shape = RoundedCornerShape(10.dp), // Card의 모서리를 둥글게 설정

    ) {
        Box(
            contentAlignment = Alignment.Center, // 아이콘을 중앙에 배치
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = iconRes),
                contentDescription = null, // 접근성 설명
                tint = Color.Unspecified // 아이콘 원래 색상 유지

            )
        }
    }
}


@Preview
@Composable
private fun SignInScreenPreview() {
    SignInScreen(
        onEmailChanged = {},
        onPasswordChanged = {},
        onSignInClicked = {},
        onSocialSignInClicked = {},
        onSignUpClicked = {}
    )


}