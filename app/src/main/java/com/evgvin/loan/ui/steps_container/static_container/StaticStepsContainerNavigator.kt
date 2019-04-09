package com.evgvin.loan.ui.steps_container.static_container

import androidx.navigation.NavDirections
import com.evgvin.loan.ui.steps_container.StepsContainerNavigator

interface StaticStepsContainerNavigator : StepsContainerNavigator {

    fun nextStep(direction: NavDirections)

}