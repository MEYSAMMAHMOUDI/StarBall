package com.example.starball.ui.news.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.starball.ui.news.viewModel.NewsViewModel
import kotlinx.coroutines.launch

/**
 * Created on : 1/15/2022
 * Author     : Meysam Mahmoudi
 */
@Composable
fun NewsList(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel()

) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val getAllNewsData = viewModel.getNewsData.observeAsState()
    val lazyListState = rememberLazyListState()

    val nestedScrollConnection = object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            val delta = available.y
            val layoutInfo = lazyListState.layoutInfo
            if (lazyListState.firstVisibleItemIndex == 0) {
                return Offset.Zero
            }
            if (layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1) {
                return Offset.Zero
            }
            return Offset.Zero
        }
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {

    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.LightGray)
    ) {

        scope.launch {
            val result = viewModel.getNewsData()
            if (result is Resource.Success) {
            } else if (result is Resource.Error) {
            }
        }

        if (!viewModel.isLoading.value) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        if (viewModel.isLoading.value) {
            if (viewModel.getNewsData.value!!.articles.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .padding(bottom = 60.dp)
                        .fillMaxSize()
                        .nestedScroll(nestedScrollConnection), state = lazyListState
                )

                {
                    items(1) { index ->
                        Box(
                            modifier = Modifier
                                .clipToBounds()
                                .fillMaxWidth()
                                .height(250.dp)
                        ) {

                            NewsStory()

                        }
                    }

                    items(getAllNewsData.value!!.articles.size) { index ->
                        NewsListItem(getAllNewsData.value!!.articles[index], navController)
                    }
                }
            }
        }
    }
}

