package com.example.starball.ui.news.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.starball.R
import com.example.starball.data.models.news.Article


@Composable
fun newsListItem(article: Article) {

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
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
                            placeholder(R.drawable.ic_launcher_background)
                            transformations(CircleCropTransformation())

                        }
                    ),
                    contentDescription = article.title,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = article.title,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                    Text(
                        text = article.description,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(4.dp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2
                    )
                    Text(
                        text = article.url,
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,

                        )

                }
            }
        }
    }

}
