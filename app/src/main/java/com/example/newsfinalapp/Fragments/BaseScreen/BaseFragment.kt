package com.example.newsfinalapp.Fragments.BaseScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.newsfinalapp.AppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaseFragment : Fragment() {

    private val viewModel: BaseViewModel by viewModel<BaseViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    BaseScreen(
                        navigate = { id, bundle -> findNavController().navigate(id, bundle) },
                        onEvent = { event -> viewModel.dispatch(event) },
                        state = viewModel.state.value
                    )
                }
            }
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }



    
}