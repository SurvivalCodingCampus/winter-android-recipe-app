package com.surivalcoding.composerecipeapp.presentation.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.BasicField
import com.surivalcoding.composerecipeapp.presentation.item.button.BigButton
import com.surivalcoding.composerecipeapp.presentation.item.button.ButtonState
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    forgotPassWord: () -> Unit,
    signIn: () -> Unit,
    googleSignIn: () -> Unit,
    facebookSignIn: () -> Unit,
    signUp: () -> Unit
) {
    val (email, emailChange) = rememberSaveable { mutableStateOf("") }
    val (password, passWordChange) = rememberSaveable { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 50.dp, bottom = 65.dp)
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Hello,",
            style = AppTextStyles.mediumTextSemiBold.copy(
                fontSize = 30.sp, color = AppColors.black
            )
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Welcome Back!",
            style = AppTextStyles.smallTextRegular.copy(
                fontSize = 20.sp, color = AppColors.label_color
            )
        )

        Spacer(modifier = Modifier.height(57.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = email, label = "Email", placeholder = "Enter Email"
        ) { newEmail ->
            emailChange(newEmail)
        }

        Spacer(modifier = Modifier.height(30.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = password, label = "Enter Password", placeholder = "Enter Password"
        ) { newPassWord ->
            passWordChange(newPassWord)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp)
                .clickable {
                    forgotPassWord()
                },
            text = "Forgot Password?",
            style = AppTextStyles.smallTextRegular.copy(
                fontSize = 11.sp,
                color = AppColors.secondary100
            )
        )

        Spacer(modifier = Modifier.height(25.dp))


        BigButton(text = "Sign In", buttonState = ButtonState.NORMAL) {
            signIn()
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(1.dp)
                    .background(AppColors.gray_4)
            )

            Text(
                text = "Or Sign In With",
                style = AppTextStyles.smallTextMedium.copy(
                    fontSize = 11.sp,
                    color = AppColors.gray_4
                )
            )

            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(1.dp)
                    .background(AppColors.gray_4)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            CustomIconButton(icon = painterResource(R.drawable.google)) {
                googleSignIn()
            }
            CustomIconButton(icon = painterResource(R.drawable.facebook)) {
                facebookSignIn()
            }
        }
        Spacer(modifier = Modifier.height(55.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "Don't have an account?", style = AppTextStyles.smallTextMedium.copy(
                    fontSize = 11.sp, color = AppColors.black
                )
            )
            Text(
                text = "Sign Up", style = AppTextStyles.smallTextMedium.copy(
                    fontSize = 11.sp, color = AppColors.secondary100
                ),
                modifier = Modifier.clickable {
                    signUp()
                }
            )
        }
    }
}

@Composable
fun CustomIconButton(
    icon: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp,
        color = AppColors.white
    ) {
        Box(
            modifier = modifier
                .padding(1.dp) // Surface와 Button 간의 간격
        ) {
            Button(
                modifier = Modifier.size(44.dp),
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // 배경색 투명하게 설정
                shape = RoundedCornerShape(8.dp), // 버튼 모서리 둥글기
                elevation = null, // 기본 Elevation 비활성화
                contentPadding = PaddingValues(0.dp)
            ) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    contentScale = ContentScale.Fit // ContentScale 변경
                )
            }
        }
    }
}