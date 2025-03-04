package com.example.newsfinalapp.Fragments.Settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.newsfinalapp.Fragments.BaseScreen.BaseScreen
import com.example.newsfinalapp.Fragments.BaseScreen.BaseViewModel

class SettingsFragment : Fragment() {

    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val navController = findNavController()
        return ComposeView(requireContext()).apply {
            setContent {
                SettingsScreen (
                    onEvent = { event -> viewModel.dispatch(event, navController, requireContext()) }
                )
            }
        }
    }
}