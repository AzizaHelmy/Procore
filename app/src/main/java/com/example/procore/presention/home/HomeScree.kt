package com.example.procore.presention.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/**
 * Created by Aziza Helmy on 25/06/2025.
 */

@Composable
fun HomeScreen(val viewModel: HomeViewModel= ){
    val state=viewModel.state.collectAsStateWithLifecycle()

    HomeContent()


}

@Composable
fun HomeContent(ui)