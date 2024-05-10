package com.nhathuy.orderdogclient.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nhathuy.orderdogclient.ui.theme.Purple40
import com.nhathuy.orderdogclient.ui.theme.PurpleGrey40
import com.nhathuy.orderdogclient.ui.theme.md_theme_dark_primaryContainer
import com.nhathuy.orderdogclient.ui.theme.md_theme_light_inverseSurface

@Composable
fun Test(text:String,
         color:Color,
         textColor: Color,
         modifier: Modifier=Modifier){
    Box(modifier = modifier
        .height(24.dp)
        .clip(
            RoundedCornerShape(
                CornerSize(12.dp),
                CornerSize(12.dp),
                CornerSize(12.dp),
                CornerSize(12.dp)
            )
        )
        .background(color),
    contentAlignment = Alignment.Center){
        Text(text = text, textAlign = TextAlign.Center,modifier=Modifier.padding(start = 12.dp, top = 5.dp, end = 12.dp, bottom = 12.dp), color = textColor, style = MaterialTheme.typography.bodySmall)
    }
}
@Preview
@Composable
fun TestPreview(){
    Test(text = "Hello Bro", color = Color.White, textColor = Color.Black)
}