package com.example.newsfinalapp.Fragments.StartScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.newsfinalapp.AppTheme
import com.example.newsfinalapp.data.api.NewsApi
import com.example.newsfinalapp.data.repository.NewsRepository

import com.example.newsfinalapp.news.ext.viewModels

class StartFragment : Fragment() {

    private val viewModel: StartViewModel by viewModels<StartViewModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val navController = findNavController()
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    StartScreen (
                        onEvent = { event -> viewModel.dispatch(event, navController, requireContext()) },
                    )
                }

            }
        }
    }
}