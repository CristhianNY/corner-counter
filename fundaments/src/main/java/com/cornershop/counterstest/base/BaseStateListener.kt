package com.cornershop.counterstest.base

interface BaseStateListener<S : BaseState> {
    fun onStateChanged(state: S)
}