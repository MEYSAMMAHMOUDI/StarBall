package com.example.starball.ui.table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.starball.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created on : 1/4/2022
 * Author     : Hamed Ghaderian
 */
@AndroidEntryPoint
class TableFragment : BaseFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply { 
            setContent {
                composale()
            }
        }
    }

    @Composable
    @Preview
    private fun composale() {
        Text(text = "Hi!")
    }
}