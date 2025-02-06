package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun ProcedureCard(
    procedure: String,
    procedureIndex: Int,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = AppColors.gray_4.copy(alpha = 0.5f),
                shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 15.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = "Step $procedureIndex",
            style = AppTextStyles.mediumTextSemiBold.copy(
                color = AppColors.label_color,
                fontSize = 11.sp
            )
        )

        Text(
            text = procedure,
            style = AppTextStyles.smallTextRegular.copy(
                color = AppColors.gray_3,
                fontSize = 11.sp
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ProcedureCardPreview() {
    ProcedureCard(
        procedure = "Prepare the pork and cut it into appropriate sizes.",
        procedureIndex = 1
    )
}