package com.example.newsfinalapp.Fragments.NewsDetailedScreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsDetailedFragment : Fragment()
{
    private val viewModel: NewsDetailedViewModel by viewModel<NewsDetailedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val id = arguments?.getInt("id") ?: 0
        val type = arguments?.getString("type") ?: "row"
        return ComposeView(requireContext()).apply {
            setContent {
                NewsDetailedScreen(
                    onEvent = { event -> viewModel.dispatch(event, type, id) },
                    state = viewModel.state.value
                )
            }
        }
    }
}