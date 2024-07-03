package com.shakibaenur.androidassociation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by Shakiba E Nur on 03,July,2024
 */
data class Topic (
    @StringRes val name:Int,
    @DrawableRes val image:Int,
    val availaleCourses:Int
)