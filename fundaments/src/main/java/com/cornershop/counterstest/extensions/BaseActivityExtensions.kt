package com.cornershop.counterstest.extensions

import androidx.annotation.LayoutRes
import com.cornershop.counterstest.base.BaseActivity
import com.cornershop.counterstest.interaction.Interaction
import com.cristhianbonilla.foundations.navigation.Navigator
import org.koin.android.ext.android.inject

internal fun BaseActivity<*>.injectInteraction() = inject<Interaction>()

internal inline fun <reified N : Navigator> BaseActivity<*>.injectNavigator() = inject<N>()

fun BaseActivity<*>.showTooltip(@LayoutRes resId: Int) {
}