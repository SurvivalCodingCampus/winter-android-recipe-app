package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun InputSignIn(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    label: String,
    imageUrl: String,
    imageUrl2: String,
    onValueChange: (String) -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = AppColors.white,
                shape = RoundedCornerShape(10.dp),
            )
    )
    {
        Column {
            Text(
                text = "Hello,",
                style = AppTextStyles.normalTextBold,
            )
            Text(
                text = "Welcome Back!",
                style = AppTextStyles.smallTextRegular,
            )
            InputField(
                modifier = modifier,
                text = text,    // 하드코딩하면 사용자가 입력을 못함
                placeholder = "Email",
                label = "Email",
                onValueChange = onValueChange
            )

            InputField(
                modifier = modifier,
                text = text,
                placeholder = "Enter Email",
                label = "Enter Email",
                onValueChange = onValueChange
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                onClick = { }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Forgot password?",
                        color = AppColors.secondary100
                    )
                }
            }


            BigButton2(
                text = "Sign In"
            )

            Text(
                text = "Or Sign in With",
                style = AppTextStyles.smallTextRegular,
            )

            Box(
                modifier = modifier
                    .width(52.dp)
                    .height(52.dp)
                    .background(
                        color = AppColors.white
                    )
            ) {
                 Column {
                     Row(
                         modifier = Modifier.fillMaxWidth(),
                         horizontalArrangement = Arrangement.Center // 가운데 정렬
                     ) {
                         Image(
                             painter = painterResource(id = R.drawable.ic_save), // 로컬 리소스
                             contentDescription = "First Local Image",
                             modifier = Modifier
                                 .width(52.dp)
                                 .height(52.dp)
                                 .clip(RoundedCornerShape(12.dp)), // 둥글게
                             contentScale = ContentScale.Crop // 크기 조절
                         )
                         Spacer(modifier = Modifier.width(16.dp))
                         Image(
                             painter = painterResource(id = R.drawable.ic_saved), // 다른 로컬 리소스
                             contentDescription = "Second Local Image",
                             modifier = Modifier
                                 .width(52.dp)
                                 .height(52.dp)
                                 .clip(RoundedCornerShape(12.dp)),
                             contentScale = ContentScale.Crop
                         )
                     }

                 }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // 여백 추가
                    horizontalArrangement = Arrangement.Center // 가운데 정렬
                ) {
                    Text(
                        text = "Don't have an account?",
                        style = AppTextStyles.smallTextRegular,
                    )
                    Text(
                        text = "Sign up",
                        style = AppTextStyles.smallTextRegular,
                        color = AppColors.primary80 // 링크 색상 변경
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignInPreview() {
    InputSignIn(
        placeholder = "Placeholder",
        label = "",
        text = "",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6UK0tNdCncAjF4lqfpwPW-G1qJ7JnBZjuyg&s",
        imageUrl2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6UK0tNdCncAjF4lqfpwPW-G1qJ7JnBZjuyg&s",
        onValueChange = {}
    )
}