package com.polware.fooddishesmenu.ui.navigation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.polware.fooddishesmenu.R
import com.polware.fooddishesmenu.data.models.MealCategoryData
import com.skydoves.landscapist.glide.GlideImage
import kotlin.math.min

@Composable
fun FoodDetailsScreen(food: MealCategoryData?, navigateBack: () -> Unit) {
    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value / 600f))
    val imageSize by animateDpAsState(targetValue = max(100.dp, 180.dp * offset))

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Food Detail") },
            navigationIcon = {
                IconButton(onClick = { navigateBack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            })
    }) {

        Surface(
            color = MaterialTheme.colors.background
        ) {
            Column() {

                Surface(elevation = 4.dp) {
                    Row(horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Card(
                            shape = CircleShape,
                            border = BorderStroke(width = 2.dp, color = Color.LightGray),
                            modifier = Modifier
                                .padding(15.dp)
                        ) {

                            GlideImage(
                                imageModel = food?.imageUrl,
                                contentScale = ContentScale.Fit,
                                error = ImageBitmap.imageResource(id = R.drawable.unavailable_image),
                                placeHolder = ImageBitmap.imageResource(id = R.drawable.unavailable_image),
                                modifier = Modifier
                                    .size(imageSize)
                                    .padding(5.dp)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                        Text(
                            text = food?.name?: "Name",
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            modifier = Modifier
                                .padding(15.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                Column(modifier = Modifier
                    .padding(15.dp)
                    .verticalScroll(scrollState)
                ) {
                    Text(
                        text = "Description:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .padding(12.dp)
                            .align(Alignment.Start)
                    )
                    Text(
                        text = food!!.description,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier
                            .padding(12.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}