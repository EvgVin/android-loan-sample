package com.evgvin.loan.data.repository

import com.evgvin.loan.data.model.CachedItem

open class CachedItemsRepository<T : CachedItem> {

    var itemsList: List<T> = ArrayList()
        set(value) {
            cachedItemsMap = setupCachedItemsMap(value)
            field = value
        }

    private lateinit var cachedItemsMap: Map<Int, T>

    fun getItem(id: Int) = cachedItemsMap[id]

    private fun setupCachedItemsMap(data: List<T>) : Map<Int, T> {
        return LinkedHashMap<Int, T>().apply {
            for (item in data) {
                this[item.id] = item
            }
        }
    }

}