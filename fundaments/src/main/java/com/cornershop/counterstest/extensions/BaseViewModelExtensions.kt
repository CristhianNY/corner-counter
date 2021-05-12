package com.cornershop.counterstest.extensions

import android.app.Application
import android.content.Context
import androidx.annotation.StringRes
import com.cornershop.counterstest.base.BaseData
import com.cornershop.counterstest.base.BaseState
import com.cornershop.counterstest.base.BaseTracker
import com.cornershop.counterstest.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun <S : BaseState, UI : BaseData<S>, T : BaseTracker> BaseViewModel<S, UI, T>
        .execute(block: suspend CoroutineScope.() -> Unit) = launch { block(this) }

@SuppressWarnings("SpreadOperator")
fun <S : BaseState, UI : BaseData<S>, T : BaseTracker> BaseViewModel<S, UI, T>
        .getString(@StringRes resId: Int, vararg formatArgs: Any)
        = getApplication<Application>().getString(resId, *formatArgs)

val <S : BaseState, UI : BaseData<S>, T : BaseTracker> BaseViewModel<S, UI, T>.context : Context
    get() = this.getApplication<Application>()