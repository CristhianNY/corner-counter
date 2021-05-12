package com.cornershop.counterstest.scope

import com.cornershop.counterstest.Scope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class IOScope : Scope {
    override val uiDispatcher: CoroutineDispatcher
        get() = Main
    override val bgDispatcher: CoroutineDispatcher
        get() = IO
}