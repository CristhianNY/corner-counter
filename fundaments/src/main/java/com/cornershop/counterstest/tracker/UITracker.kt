package com.cornershop.counterstest.tracker

import com.cornershop.counterstest.tracker.MyTrackerEvent
import com.cornershop.counterstest.tracker.MyTrackerUserData
import com.cornershop.counterstest.tracker.MyTrackerView


interface UITracker {

    fun initialize()

    fun setUserData(userDataModel: MyTrackerUserData)

    fun view(view: MyTrackerView)

    fun event(event: MyTrackerEvent)
}