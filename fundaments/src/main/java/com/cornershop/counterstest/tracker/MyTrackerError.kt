package com.cornershop.counterstest.tracker

data class MyTrackerError(
    val category: String,
    val description: String?,
    val status: String?,
    val number: Long?
)