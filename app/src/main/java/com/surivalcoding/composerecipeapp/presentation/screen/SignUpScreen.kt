package com.surivalcoding.composerecipeapp.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.InputField
import com.surivalcoding.composerecipeapp.presentation.component.SocialLogin
import com.surivalcoding.composerecipeapp.ui.component.NoPaddingButton
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun SignUpScreen(
    name: String,
    email: String,
    password: String,
    confirmPassword: String,
    selectedTerms: Boolean,
    onTermsChange: (Boolean) -> Unit,
    onSignUpClick: () -> Unit,
    loginWithGoogle: () -> Unit,
    loginWithFacebook: () -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.White)
            .padding(horizontal = 30.dp)
    ) {
        SignUpHeader(modifier = Modifier.padding(top = 10.dp, bottom = 20.dp))
        SignUpInputField(
            name = name,
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onNameChange = onNameChange,
            onConfirmPasswordChange = onConfirmPasswordChange,
            modifier = Modifier
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 26.dp)
                .clickable {
                    onTermsChange(!selectedTerms)
                }
        ) {
            CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides Dp.Unspecified) {
                Checkbox(
                    checked = selectedTerms,
                    onCheckedChange = onTermsChange,
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Transparent,
                        uncheckedColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .size(16.dp)
                        .border(
                            BorderStroke(1.dp, AppColors.Secondary100),
                            RoundedCornerShape(5.dp)
                        )
                )
            }
            Spacer(Modifier.width(5.dp))
            Text(
                text = "Accept terms & Condition",
                style = AppTextStyles.smallerTextRegular,
                color = AppColors.Secondary100
            )
        }
        BigButton(
            text = "Sign Up",
            onClick = onSignUpClick,
        )
        LoginDivider(Modifier.padding(top = 14.dp, bottom = 20.dp))
        SocialLogin(
            loginWithGoogle = loginWithGoogle,
            loginWithFacebook = loginWithFacebook,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Already a member?  ", style = AppTextStyles.smallerTextSemiBold
            )
            NoPaddingButton(
                onClick = onSignUpClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent, contentColor = AppColors.Secondary100
                )
            ) {
                Text(
                    text = "Sign In", style = AppTextStyles.smallerTextSemiBold
                )
            }
        }
    }
}

@Composable
private fun SignUpHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Create an account", style = AppTextStyles.largeTextBold
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Let's help you set up your account,\nit won't take long",
            style = AppTextStyles.smallerTextRegular
        )
    }
}

@Composable
fun SignUpInputField(
    name: String,
    email: String,
    password: String,
    confirmPassword: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        InputField(
            value = name,
            label = "Name",
            placeholder = "Enter Name",
            onValueChange = onNameChange,
        )
        InputField(
            value = email,
            label = "Email",
            placeholder = "Enter Email",
            onValueChange = onEmailChange,
        )
        InputField(
            value = password,
            label = "Password",
            placeholder = "Enter Email",
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation()
        )
        InputField(
            value = confirmPassword,
            label = "ConfirmPassword",
            placeholder = "Enter Email",
            onValueChange = onConfirmPasswordChange,
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    ComposeRecipeAppTheme {
        SignUpScreen(
            name = "",
            email = "",
            password = "",
            confirmPassword = "",
            selectedTerms = false,
            onTermsChange = {},
            onSignUpClick = {},
            loginWithGoogle = {},
            loginWithFacebook = {},
            onEmailChange = {},
            onPasswordChange = {},
            onNameChange = {},
            onConfirmPasswordChange = {},
        )
    }
}