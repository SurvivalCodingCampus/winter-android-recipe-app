package com.surivalcoding.composerecipeapp.presentation.component.page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BasicField
import com.surivalcoding.composerecipeapp.presentation.component.button.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.button.ButtonState
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    checkText: String,
    buttonText: String,
    signDescription: String,
    memberText: String,
    signText: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 10.dp, start = 30.dp, end = 30.dp)
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            style = AppTextStyles.mediumTextSemiBold.copy(
                fontSize = 20.sp, color = AppColors.black
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            modifier = Modifier
                .width(195.dp)
                .align(Alignment.Start),
            text = subTitle,
            style = AppTextStyles.smallTextRegular.copy(
                fontSize = 11.sp, color = AppColors.label_color
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = "", label = "Name", placeholder = "Enter Name"
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = "", label = "Email", placeholder = "Enter Email"
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = "", label = "Password", placeholder = "Enter Password"
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = "", label = "Confirm Password", placeholder = "Retype Password"
        )

        Spacer(Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {

            CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides Dp.Unspecified) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { onCheckedChange(it) },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Transparent,
                        uncheckedColor = Color.Transparent,
                        checkmarkColor = AppColors.secondary100
                    ),
                    modifier = Modifier
                        .size(17.dp)
                        .border(
                            width = 1.dp,
                            color = AppColors.secondary100,
                            shape = RoundedCornerShape(5.dp)
                        )
                )
            }

            Text(
                text = checkText,
                style = AppTextStyles.smallTextRegular.copy(
                    fontSize = 11.sp, color = AppColors.secondary100
                )
            )
        }

        Spacer(Modifier.height(26.dp))


        BigButton(text = buttonText, buttonState = ButtonState.NORMAL)

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
                text = signDescription,
                style = AppTextStyles.mediumTextSemiBold.copy(
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
            CustomIconButton(icon = painterResource(R.drawable.google)) {}
            CustomIconButton(icon = painterResource(R.drawable.facebook)) {}
        }

        Spacer(Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = memberText, style = AppTextStyles.mediumTextSemiBold.copy(
                    fontSize = 11.sp,
                    color = AppColors.black
                )
            )
            Text(
                text = signText, style = AppTextStyles.mediumTextSemiBold.copy(
                    fontSize = 11.sp,
                    color = AppColors.secondary100
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(modifier: Modifier = Modifier) {

    var isChecked by remember { mutableStateOf(false) }
    SignUpScreen(
        title = "Create an account",
        subTitle = "Let's help you set up your account, it won't take long.",
        checkText = "Accept terms & Condition",
        buttonText = "Sign Up",
        signDescription = "Or Sign in With",
        memberText = "Already a member?",
        signText = "Sign In",
        isChecked = isChecked
    ) { newChecked ->
        isChecked = newChecked
    }
}