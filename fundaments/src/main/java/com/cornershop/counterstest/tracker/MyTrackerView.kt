package com.cornershop.counterstest.tracker

import com.cornershop.counterstest.tracker.*

class MyTrackerView (
    val name: String,
    val sectionFamily: MyTrackerSectionFamily,
    val sectionCategory: MyTrackerSectionCategory,
    val sectionName: MyTrackerSectionName,
    val screenType: MyTrackerScreenType? = null,
    val eventName: MyTrackerEventNameType? = null,
    val productName: String? = null,
    val interactionType: MyTrackerInteractionType? = null,
    val processType: String? = null,
    val processStep: String? = null,
    val serviceType: MyTrackerServiceType? = null,
    val error: MyTrackerError? = null
)