package com.surivalcoding.composerecipeapp.presentation.component.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.makeInputField
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    var isCheckBoxSelected by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(color = AppColors.white)
            .fillMaxSize()
            .padding(top = 54.dp, start = 30.dp),
    ) {
        Text(
            text = "Create an account",
            style = AppTextStyles.largeTextBold
        )
        Text(
            text = "let's help you set up your account, \nit won't take long",
            style = AppTextStyles.smallerTextRegular
        )

        Spacer(
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        makeInputField(
            title = "Name",
            placeholder = "Enter Name"
        )
        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )
        makeInputField(
            title = "Email",
            placeholder = "Enter Email"
        )
        Spacer(
            modifier = Modifier
                .padding(vertical = 10.dp)
        )
        makeInputField(
            title = "Password",
            placeholder = "Enter Password"
        )
        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )
        makeInputField(
            title = "Confirm Password",
            placeholder = "Retype Password"
        )
        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )

        Row(
            modifier = Modifier
                .padding(start = 10.dp)
        ) {
            /*
            Box(
                modifier = Modifier
                    .size(17.dp)
                    .border(
                        width = 1.dp,
                        color = AppColors.Secondary_100,
                        shape = RoundedCornerShape(5.dp)
                    )
            )
            */
            Checkbox(
                modifier = Modifier
                    .size(17.dp),
                checked = isCheckBoxSelected,
                onCheckedChange = { check ->
                    isCheckBoxSelected = check
                },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = AppColors.Secondary_100,
                    checkedColor = AppColors.Secondary_100
                )
            )
            Text(
                modifier = Modifier
                    .padding(start = 5.dp),
                text = "Accept terms & Condition",
                style = AppTextStyles.smallerTextRegular,
                color = AppColors.Secondary_100
            )
        }


        Spacer(
            modifier = Modifier
                .padding(vertical = 13.dp)
        )

        BigButton(
            title = "Sign Up"
        )

        Spacer(
            modifier = Modifier
                .padding(vertical = 7.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Divider(
                modifier = Modifier
                    .width(50.dp),
                thickness = 1.dp,
            )
            Text(
                text = "Or Sign in With",
                style = AppTextStyles.smallerTextSemiBold,
                color = AppColors.gray_04
            )
            Divider(
                modifier = Modifier
                    .width(50.dp),
                thickness = 1.dp
            )
        }

        Spacer(
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        Row(
            modifier = Modifier
                .padding(start = 101.dp),
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(44.dp),
                painter = painterResource(
                    id = R.drawable.google_logo
                ),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .size(44.dp),
                painter = painterResource(
                    id = R.drawable.facebook_logo
                ),
                contentDescription = null
            )
        }

        Spacer(
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        Row(
            modifier = Modifier
                .padding(start = 83.dp)
        ) {
            Text(
                text = "Already a member? ",
                style = AppTextStyles.smallerTextSemiBold
            )
            Text(
                modifier = Modifier
                    .clickable {
                        onClick()
                    },
                text = "Sign In",
                style = AppTextStyles.smallerTextSemiBold,
                color = AppColors.Secondary_100
            )
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen()
}