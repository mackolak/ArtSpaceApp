package com.example.artspace

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.artspace.ui.theme.ArtSpaceTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleInstrumentedTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                MainLayout()
            }
        }

//        composeTestRule.onNodeWithText("Bill Amount")
//            .performTextInput("10")
//        composeTestRule.onNodeWithText("Tip Percentage")
//            .performTextInput("20")
//
//        composeTestRule.onNodeWithText("Tip Amount: $2.00")
//            .assertExists("No node with this text was found")
    }
}