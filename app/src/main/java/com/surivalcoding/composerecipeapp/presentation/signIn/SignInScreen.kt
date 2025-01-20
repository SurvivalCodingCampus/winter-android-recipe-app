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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalRuler
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
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = AppColors.white,
            )
            .padding(horizontal = 30.dp),
    ) {
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
        Spacer(modifier = Modifier.height(16.dp))

        // 선
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = modifier
                    .weight(1f)
                    .height(1.dp), color = AppColors.gray4
            )
            Text(
                modifier = modifier.padding(10.dp),
                text = "Or Sign in With",
                style = AppTextStyles.smallTextRegular,
                color = AppColors.gray4
            )
            HorizontalDivider(
                modifier = modifier
                    .weight(1f)
                    .height(1.dp), color = AppColors.gray4
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center // 가운데 정렬
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.LightGray) // 회색 박스
                    .padding(4.dp) // 이미지와 박스 간 여백
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = "First Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // 두 번째 이미지
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.LightGray) // 회색 박스
                    .padding(4.dp) // 이미지와 박스 간 여백
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_saved),
                    contentDescription = "Second Image",
                    modifier = Modifier.fillMaxSize(),
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