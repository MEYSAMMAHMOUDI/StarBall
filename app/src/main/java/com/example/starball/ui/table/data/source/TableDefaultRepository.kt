package com.example.starball.ui.table.data.source

import com.example.starball.data.RemoteDataSource
import com.example.starball.ui.table.data.source.remote.TableRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Created on : 1/4/2022
 * Author     : Hamed Ghaderian
 */
class TableDefaultRepository @Inject constructor(
    @RemoteDataSource val remoteDataSource: TableRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TableRepository