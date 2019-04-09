package com.evgvin.loan.ui.base

interface BaseItemNavigator<T> {

    fun itemClicked(data: T, position: Int)

}