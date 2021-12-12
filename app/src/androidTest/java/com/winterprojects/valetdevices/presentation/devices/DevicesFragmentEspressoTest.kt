package com.winterprojects.valetdevices.presentation.devices

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.winterprojects.valetdevices.R
import com.winterprojects.valetdevices.presentation.home.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class DevicesFragmentEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun checkSearchViewDevicesIsVisible() {
        onView(withId(R.id.searchViewDevices)).check(matches(isDisplayed()))
    }

    @Test
    fun checkRecyclerViewItemsAreLoaded() {
        onView(withText("Gas Sensor"))
            .check(matches(isDisplayed()))
    }
}