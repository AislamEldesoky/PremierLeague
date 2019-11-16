package com.example.premierleague

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KakaoActivityTest {
    @JvmField
    @Rule
    val testRule =ActivityTestRule(MainActivity::class.java)

    private val kakaoScreen = KakaoScreen()

    @Test
    fun initialViewsDisplayed(){
        kakaoScreen{
            nameTextView{isDisplayed()}
            webTextView{isDisplayed()}
            colorTextView{isDisplayed()}
            venueTextView{isDisplayed()}
            infoButton{isDisplayed()}
        }
    }

}