package com.example.newsfinalapp.Fragments.BaseScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.newsfinalapp.AppTheme
import com.example.newsfinalapp.Fragments.StartScreen.StartViewModel
import com.example.newsfinalapp.NetworkApi
import com.example.newsfinalapp.data.api.NewsApi
import com.example.newsfinalapp.data.repository.NewsRepository
import com.example.newsfinalapp.news.ext.viewModels

class BaseFragment : Fragment() {

    private val viewModel: BaseViewModel by viewModels(
        viewModelInitializer = {
            BaseViewModel(
                findNavController(),
                requireContext()
            )
        }
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    BaseScreen(
                        onEvent = { event -> viewModel.dispatch(event) },
                        state = viewModel.state.value
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.dispatch(BaseEvent.OnGetNews)
    }

    
}