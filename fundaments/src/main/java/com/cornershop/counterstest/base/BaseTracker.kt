package com.cornershop.counterstest.base

import com.cornershop.counterstest.tracker.MyTrackerEvent
import com.cornershop.counterstest.tracker.MyTrackerView

abstract class BaseTracker {

    abstract fun viewDisplayed()

    fun view(view: MyTrackerView) {
        //uiTracker.view(view)
    }

    fun event(event: MyTrackerEvent) {
     //   uiTracker.event(event)
    }
}