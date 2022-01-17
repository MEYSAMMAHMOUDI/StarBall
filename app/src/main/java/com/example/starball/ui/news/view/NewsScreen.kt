package com.example.starball.ui.news.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.starball.R
import com.example.starball.data.models.news.Article

/**
 * Created on : 1/15/2022
 * Author     : Meysam Mahmoudi
 */
@Composable
fun NewsListItem(article: Article) {
    val context = LocalContext.current
    if ((article.title != null) && (article.description != null)) {
        Card(
            modifier = Modifier
                .padding(3.dp, 3.dp)
                .fillMaxWidth()
                .height(110.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp,
            backgroundColor = Color(R.color.white)
        ) {
            Surface() {

                Row(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {

                    Image(
                        painter = rememberImagePainter(
                            data = article.urlToImage,
                            builder = {
                                scale(Scale.FILL)
                                placeholder(R.drawable.ic_defulte_news)
                                transformations(CircleCropTransformation())

                            }

                        ),
                        contentDescription = article.title,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.5f)
                    )

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxHeight()
                            .weight(0.7f)
                    ) {

                        Text(
                            text = "${article.title}",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            color = Color.Black,

                            )

                        Text(
                            text = "${article.description}",
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier
                                .padding(4.dp),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 2,
                            color = Color.Black
                        )

                    }
                }
            }
        }
    }
}