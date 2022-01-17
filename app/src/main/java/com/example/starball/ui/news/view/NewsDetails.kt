package com.example.starball.ui.news.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import kotlin.math.max
import kotlin.math.min
import com.example.starball.R
import com.example.starball.data.models.news.Article
/**
 * Created on : 1/17/2022
 * Author     : Meysam Mahmoudi
 */
@Composable
fun NewsDetails(scrollState: ScrollState, navController: NavController, article: Article) {


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBar(
            title = {
            },
            navigationIcon = {

                IconButton(
                    onClick = { navController.navigate("News") },
                ) {
                    Icon(
                        Icons.Outlined.ArrowBack,
                        contentDescription = "Back option",
                        tint = Color.Green,
                    )
                }
            }
        )

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {
            val height = 400.dp
            Image(
                painter = rememberImagePainter(data = article.urlToImage),
                contentDescription = "Banner Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height)
                    .graphicsLayer {
                        alpha = min(
                            1f,
                            max(
                                0.0f,
                                1 - (scrollState.value / ((height.value * 2) + (height.value / 1.5f)))
                            )
                        )
                    }
            )
            Text(
                text = article.title,
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                modifier = Modifier.padding(10.dp),
                maxLines = 1,
                style = TextStyle(
                    lineHeight = 25.sp,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = article.description,
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = FontFamily.Default,
                modifier = Modifier.padding(10.dp),
                style = TextStyle(
                    lineHeight = 60.sp,
                    textAlign = TextAlign.Justify
                )
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewDetails() {
    val scrollState = rememberScrollState()
    val navController = rememberNavController()
    var article = Article("", "", "", "", "")

    NewsDetails(scrollState, navController, article)
}