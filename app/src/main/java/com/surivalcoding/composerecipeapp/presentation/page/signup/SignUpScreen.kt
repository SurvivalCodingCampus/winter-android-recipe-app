package com.surivalcoding.composerecipeapp.presentation.page.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.BasicField
import com.surivalcoding.composerecipeapp.presentation.item.button.BigButton
import com.surivalcoding.composerecipeapp.presentation.item.button.ButtonState
import com.surivalcoding.composerecipeapp.presentation.page.signin.CustomIconButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    googleSignIn: () -> Unit,
    facebookSignIn: () -> Unit,
    signIn: () -> Unit,
    signUp: () -> Unit,
) {

    val (email, emailChange) = rememberSaveable { mutableStateOf("") }
    val (password, passWordChange) = rememberSaveable { mutableStateOf("") }
    val (name, nameChange) = rememberSaveable { mutableStateOf("") }
    val (passWordConfirm, passWordConfirmChange) = rememberSaveable { mutableStateOf("") }
    val (isChecked, onCheckedChange) = rememberSaveable { mutableStateOf(false) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 10.dp, start = 30.dp, end = 30.dp)
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Create an account",
            style = AppTextStyles.mediumTextSemiBold.copy(
                fontSize = 20.sp, color = AppColors.black
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            modifier = Modifier
                .width(195.dp)
                .align(Alignment.Start),
            text = "Let's help you set up your account, it won't take long.",
            style = AppTextStyles.smallTextRegular.copy(
                fontSize = 11.sp, color = AppColors.label_color
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = name, label = "Name", placeholder = "Enter Name"
        ) { newName ->
            nameChange(newName)
        }

        Spacer(modifier = Modifier.height(20.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = email, label = "Email", placeholder = "Enter Email"
        ) { newEmail ->
            emailChange(newEmail)
        }

        Spacer(modifier = Modifier.height(20.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = password, label = "Password", placeholder = "Enter Password"
        ) { newPassWord ->
            passWordChange(newPassWord)
        }

        Spacer(modifier = Modifier.height(20.dp))

        BasicField(
            modifier = Modifier.fillMaxWidth(),
            value = passWordConfirm, label = "Confirm Password", placeholder = "Retype Password"
        ) { newPassWordConfirm ->
            passWordConfirmChange(newPassWordConfirm)
        }

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
                text = "Accept terms & Condition",
                style = AppTextStyles.smallTextRegular.copy(
                    fontSize = 11.sp, color = AppColors.secondary100
                )
            )
        }

        Spacer(Modifier.height(26.dp))


        BigButton(text = "Sign Up", buttonState = ButtonState.NORMAL) {
            signUp()
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
                text = "Or Sign in With",
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

        Spacer(Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "Already a member?", style = AppTextStyles.smallTextMedium.copy(
                    fontSize = 11.sp,
                    color = AppColors.black
                )
            )
            Text(
                text = "Sign In", style = AppTextStyles.smallTextMedium.copy(
                    fontSize = 11.sp,
                    color = AppColors.secondary100
                ),
                modifier = Modifier.clickable {
                    signIn()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(modifier: Modifier = Modifier) {

    SignUpScreen(
        signUp = {},
        googleSignIn = {},
        facebookSignIn = {},
        signIn = {},
    )
}