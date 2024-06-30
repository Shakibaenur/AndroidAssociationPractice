package com.shakibaenur.androidassociation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shakibaenur.androidassociation.ui.theme.AndroidAssociationTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.text.NumberFormat

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.shakibaenur.androidassociation", appContext.packageName)
//    }

    @get:Rule
    val composeTestRule= createComposeRule()

    @Test
    fun calculateTip_20PercentNoRoundUp() {
        composeTestRule.setContent {
            AndroidAssociationTheme {
                TipTimeLayout()
            }
        }

        // Enter the bill amount
        composeTestRule.onNodeWithTag("BillAmountField").performTextInput("10")
        // Enter the tip percentage
        composeTestRule.onNodeWithTag("TipPercentageField").performTextInput("20")

        // Format the expected tip amount
        val expectedTip = NumberFormat.getCurrencyInstance().format(2.0)

        // Verify that the calculated tip is displayed correctly
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertIsDisplayed()
    }
}