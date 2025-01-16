package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R

@Composable
fun SocialLogin(
    loginWithGoogle: () -> Unit,
    loginWithFacebook: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth(),
    ) {
        ElevatedCard(
            onClick = loginWithGoogle,
            shape = RoundedCornerShape(10.dp), colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.google_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .size(24.dp),
            )
        }
        Spacer(Modifier.width(25.dp))
        ElevatedCard(
            onClick = loginWithFacebook,
            shape = RoundedCornerShape(10.dp), colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.facebook_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .size(24.dp),
            )
        }
    }
}