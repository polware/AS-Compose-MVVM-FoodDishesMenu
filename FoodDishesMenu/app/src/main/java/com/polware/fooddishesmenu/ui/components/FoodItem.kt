package com.polware.fooddishesmenu.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.polware.fooddishesmenu.R
import com.polware.fooddishesmenu.data.models.MealCategoryData
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun FoodItem(food: MealCategoryData, navigationCallback: (String) -> Unit) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .clickable {
                navigationCallback(food.id)
            }
    ) {
        Row(modifier = Modifier.animateContentSize()) {

            GlideImage(
                imageModel = food.imageUrl,
                contentScale = ContentScale.Fit,
                error = ImageBitmap.imageResource(id = R.drawable.unavailable_image),
                placeHolder = ImageBitmap.imageResource(id = R.drawable.unavailable_image),
                modifier = Modifier
                    .size(92.dp)
                    .padding(5.dp)
                    .align(Alignment.CenterVertically)
            )

            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth(0.8f)
                .padding(12.dp)
            ) {

                Text(
                    text = food.name,
                    style = MaterialTheme.typography.h6
                )

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = food.description,
                        textAlign = TextAlign.Justify ,
                        style = MaterialTheme.typography.subtitle2,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if (isExpanded) 10 else 4
                    )
                }
            }

            Icon(
                imageVector = if (isExpanded)
                    Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand row icon",
                modifier = Modifier
                    .padding(15.dp)
                    .align(
                        if (isExpanded)
                            Alignment.Bottom
                        else Alignment.CenterVertically
                    )
                    .clickable {
                        isExpanded = !isExpanded
                    }
            )
        }
    }
}