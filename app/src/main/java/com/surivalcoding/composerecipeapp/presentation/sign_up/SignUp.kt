package com.surivalcoding.composerecipeapp.presentation.sign_up

import CustomCheckbox
import DividerWithText
import SocialLoginButton
import TextWithLink
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.global.button.BaseButton
import com.surivalcoding.composerecipeapp.presentation.component.global.text.CustomTextField
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SignUpScreen(
    onSignUpClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    onFacebookSignInClick: () -> Unit,
    onSignInClick: () -> Unit,
    onTermsClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 30.dp, vertical = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Create an Account",
            style = AppTextStyles.boldLarge
        )
        Text(
            text = "Let's help you set up Your account,\nit won't take long.",
            style = AppTextStyles.regularMedium
        )

        CustomTextField(
            value = name,
            onValueChange = { name = it },
            label = "Name",
            placeholder = "Enter Name"
        )

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder = "Enter Email"
        )

        CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            placeholder = "Enter Password"
        )

        CustomTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirm Password",
            placeholder = "Retype Password"
        )

        Row(
            modifier = Modifier.padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomCheckbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
            Text(
                "Accept terms & Condition",
                style = AppTextStyles.regularSmall,
                color = AppColors.Secondary100,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable { onTermsClick() }
            )
        }

        BaseButton(
            modifier = Modifier.fillMaxWidth(),
            width = 240.dp,
            height = 60.dp,
            text = "Sign Up",
            color = AppColors.Primary100,
            fontStyle = AppTextStyles.boldNormal,
            iconSize = 20.dp,
            enabled = true,
            onClick = onSignUpClick
        )

        DividerWithText(text = "Or Sign in With")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialLoginButton(
                icon = R.drawable.icons_google,
                onClick = onGoogleSignInClick
            )
            Spacer(modifier = Modifier.width(20.dp))
            SocialLoginButton(
                icon = R.drawable.facebook,
                onClick = onFacebookSignInClick
            )
        }

        TextWithLink(
            text = "Already a member?",
            linkText = "Sign In",
            onClick = onSignInClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        onSignUpClick = {},
        onGoogleSignInClick = {},
        onFacebookSignInClick = {},
        onSignInClick = {},
        onTermsClick = {}
    )
}