package com.surivalcoding.composerecipeapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.InputField
import com.surivalcoding.composerecipeapp.presentation.component.SocialLogin
import com.surivalcoding.composerecipeapp.ui.component.NoPaddingButton
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun SignInScreen(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    onSignInClick: () -> Unit,
    loginWithGoogle: () -> Unit,
    loginWithFacebook: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.White)
            .padding(horizontal = 30.dp)
    ) {
        LoginHeader(Modifier.padding(top = 50.dp, bottom = 56.dp))
        LoginInputField(
            email = email,
            password = password,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange
        )
        NoPaddingButton(
            onClick = onForgotPasswordClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent, contentColor = AppColors.Secondary100
            ),
            modifier = Modifier.padding(start = 10.dp, top = 20.dp, bottom = 25.dp)
        ) {
            Text(
                text = "Forget Password",
                style = AppTextStyles.smallerTextRegular,
            )
        }
        BigButton(
            text = "Sign In",
            onClick = onSignInClick,
        )
        LoginDivider(modifier = Modifier.padding(vertical = 20.dp))
        SocialLogin(
            loginWithGoogle = loginWithGoogle,
            loginWithFacebook = loginWithFacebook,
            modifier = Modifier.padding(bottom = 55.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Don't have an account? ", style = AppTextStyles.smallerTextSemiBold
            )
            NoPaddingButton(
                onClick = onSignUpClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent, contentColor = AppColors.Secondary100
                )
            ) {
                Text(
                    text = "Sign Up", style = AppTextStyles.smallerTextSemiBold
                )
            }
        }
    }
}

@Composable
private fun LoginHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Hello,", style = AppTextStyles.headerTextSemiBold
        )
        Text(
            text = "Welcome Back!", style = AppTextStyles.largeTextRegular
        )
    }
}

@Composable
private fun LoginInputField(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        InputField(
            value = email, label = "Email", placeholder = "Enter Email",
            onValueChange = { text ->
                onEmailChange(text)
            },
        )
        Spacer(Modifier.height(30.dp))
        InputField(
            value = password,
            label = "Enter Password",
            placeholder = "Enter Password",
            onValueChange = { text ->
                onPasswordChange(text)
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun LoginDivider(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            color = AppColors.Gray4,
            modifier = Modifier.width(50.dp),
        )
        Text(
            text = "Or Sign In With",
            style = AppTextStyles.smallerTextSemiBold,
            color = AppColors.Gray4,
            modifier = Modifier.padding(horizontal = 7.dp)
        )
        HorizontalDivider(
            color = AppColors.Gray4,
            modifier = Modifier.width(50.dp),
        )
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    ComposeRecipeAppTheme {
        SignInScreen(
            email = "",
            password = "",
            onEmailChange = {},
            onPasswordChange = {},
            onSignInClick = {},
            loginWithGoogle = {},
            loginWithFacebook = {},
            onForgotPasswordClick = {},
            onSignUpClick = {},
        )
    }
}