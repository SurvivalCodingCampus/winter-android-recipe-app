package com.surivalcoding.composerecipeapp.presentation.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.button.BaseButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SignUpScreen() {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 30.dp, top = 30.dp, end = 30.dp)
            .verticalScroll(scrollState),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
        ) {
            Text(
                text = "Create an Account",
                modifier = Modifier.padding(bottom = 5.dp),
                style = AppTextStyles.boldLarge,
            )
            Text(
                text = "Let's help you set up Your account,\nit won't take long.",
                style = AppTextStyles.regularMedium
            )

            Box(
                modifier = Modifier.padding(top = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        20.dp,
                        Alignment.CenterVertically
                    )
                ) {
                    Column {
                        Text(
                            text = "Name",
                            style = AppTextStyles.regularSmall,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        OutlinedTextField(
                            value = text,
                            onValueChange = { text = it },
                            placeholder = {
                                Text(
                                    text = "Enter Name",
                                    style = AppTextStyles.regularSmaller,
                                    color = AppColors.LabelWhite
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(size = 10.dp))
                                .border(
                                    width = 1.5.dp,
                                    color = Color(0xFFD9D9D9),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .width(315.dp)
                                .height(55.dp)
                        )
                    }

                    Column {
                        Text(
                            text = "Email",
                            style = AppTextStyles.regularSmall,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        OutlinedTextField(
                            value = text,
                            onValueChange = { text = it },
                            placeholder = {
                                Text(
                                    text = "Enter Email",
                                    style = AppTextStyles.regularSmaller,
                                    color = AppColors.LabelWhite
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(size = 10.dp))
                                .border(
                                    width = 1.5.dp,
                                    color = Color(0xFFD9D9D9),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .width(315.dp)
                                .height(55.dp)
                        )
                    }
                    Column {
                        Text(
                            text = "Password",
                            style = AppTextStyles.regularSmall,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        OutlinedTextField(
                            value = text,
                            onValueChange = { text = it },
                            placeholder = {
                                Text(
                                    text = "Enter Password",
                                    style = AppTextStyles.regularSmaller,
                                    color = AppColors.LabelWhite
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(size = 10.dp))
                                .border(
                                    width = 1.5.dp,
                                    color = Color(0xFFD9D9D9),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .width(315.dp)
                                .height(55.dp)
                        )
                    }

                    Column(
                    ) {
                        Text(
                            text = "Confirm Password",
                            style = AppTextStyles.regularSmall,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )

                        OutlinedTextField(
                            value = text,
                            onValueChange = { password = it },
                            placeholder = {

                                Text(
                                    text = "Retype Password",
                                    style = AppTextStyles.regularSmaller,
                                    color = AppColors.LabelWhite
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(size = 10.dp))
                                .border(
                                    width = 1.5.dp,
                                    color = Color(0xFFD9D9D9),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .width(315.dp)
                                .height(55.dp)
                        )
                    }

                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,

                        ) {

                            CustomCheckbox(
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                modifier = Modifier.padding(start = 10.dp)
                            )
                            Text(
                                "Accept terms & Condition",
                                style = AppTextStyles.regularSmall,
                                color = AppColors.Secondary100,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        }
                    }

                    BaseButton(
                        modifier = Modifier.fillMaxWidth(),
                        width = 240.dp,
                        height = 60.dp,
                        text = "Sign Up",
                        color = AppColors.Primary100,
                        fontStyle = AppTextStyles.boldNormal,
                        iconSize = 20.dp,
                        enabled = true
                    ) {

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HorizontalDivider(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 16.dp),
                            thickness = 1.dp,
                            color = AppColors.LabelWhite
                        )
                        Text(
                            text = "Or Sign in With",
                            style = AppTextStyles.regularSmall,
                            color = AppColors.LabelWhite
                        )
                        HorizontalDivider(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp),
                            color = AppColors.LabelWhite,
                            thickness = 1.dp
                        )
                    }


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            20.dp,
                            Alignment.CenterHorizontally
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .shadow(
                                    elevation = 5.dp,
                                    spotColor = Color.Black,
                                    ambientColor = Color.Black,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icons_google),
                                contentDescription = "image description",
                                contentScale = ContentScale.None
                            )

                        }

                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .shadow(
                                    elevation = 5.dp,
                                    spotColor = Color.Black,
                                    ambientColor = Color.Black,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.facebook),
                                contentDescription = "image description",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(26.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .background(
                                        color = Color.White,
                                        shape = RoundedCornerShape(10.dp)
                                    )

                            )

                        }


                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text("Already a member?")
                            Text(
                                "Sign Up",
                                style = AppTextStyles.regularSmall.copy(color = AppColors.Secondary100)
                            )
                        }
                    }
                }
            }
        }


    }


}

@Composable
fun CustomCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color(0xFFFF9C00),
                shape = RoundedCornerShape(size = 5.dp)
            )
            .width(17.dp)
            .height(17.dp)
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 5.dp)
            )
            .clickable(enabled = enabled) { onCheckedChange(!checked) },
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Checked",
                modifier = Modifier.size(12.dp),
                tint = Color(0xFFFF9C00)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}