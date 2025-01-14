package com.example.newsfinalapp.news.ext

import android.app.Activity
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

@MainThread
inline fun <reified VM : ViewModel> Fragment.viewModels(
    noinline viewModelInitializer: () -> VM
): Lazy<VM> {
    val owner by lazy(LazyThreadSafetyMode.NONE) { this }
    return createViewModelLazy(
        viewModelClass = VM::class,
        storeProducer = { owner.viewModelStore },
        extrasProducer = { CreationExtras.Empty },
        factoryProducer = {
            viewModelFactory {
                initializer { viewModelInitializer() }
            }
        }
    )
}

