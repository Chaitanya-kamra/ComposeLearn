package com.example.composelearn.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val number: Int,
    @DrawableRes val image: Int)

