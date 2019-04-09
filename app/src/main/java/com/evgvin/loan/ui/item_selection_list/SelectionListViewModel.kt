package com.evgvin.loan.ui.item_selection_list

import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.evgvin.loan.data.model.SelectionItem
import com.evgvin.loan.ui.steps_container.step.StepViewModel

open class SelectionListViewModel : StepViewModel() {

    val title = ObservableField<String>()
    val descriptionVisible = ObservableBoolean()
    val description: ObservableField<String> by lazy {
        ObservableField<String>().apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    descriptionVisible.set(!this@apply.get().isNullOrEmpty())
                }
            })
        }
    }

    /**
     * All item positions that the user has selected.
     */
    var selectedItemPositions = MutableLiveData<ArrayList<Int>?>()

    /**
     * This variable is used when the selection mode of the list is [SelectionListFragment.SELECTION_MODE.SINGLE].
     */
    var singleSelectedItemPosition: Int? = null
        get() {
            selectedItemPositions.value.apply {
                return this?.let { if (this.size > 0) this[0] else null }
            }
        }
        set(value) {
            value?.let { itemSelectedSingleMode(it) }
            field = value
        }

    /**
     * String items are the base data for selection list.
     * After initialization, they are transformed in [selectionItems].
     */
    val stringItems = MutableLiveData<Array<String>>()
    val selectionItems = Transformations.map(stringItems) {
        transformStringsToSelectionItems(it).apply {
            selectedItemPositions.value?.let {
                for (selectedPosition in it) {
                    this[selectedPosition].isSelected = true
                }
            }
        }
    }

    fun itemSelectedSingleMode(position: Int) {
        selectedItemPositions.value = arrayListOf(position)
    }

    fun itemSelectedMultiMode(position: Int, item: SelectionItem?) {
        if (selectedItemPositions.value == null) {
            itemSelectedSingleMode(position)
        } else {
            selectedItemPositions.value?.let {
                val isAlreadySelected = it.contains(position)
                val isItemSelected = item?.isSelected ?: false
                if (isAlreadySelected && isItemSelected) return
                if (isAlreadySelected) {
                    if (it.size == 1) {
                        selectedItemPositions.value = null
                    } else {
                        it -= position
                    }
                } else {
                    it += position
                }
            }
        }
    }

    fun enabledNextStep() = selectedItemPositions.value != null

    private fun transformStringsToSelectionItems(strings: Array<String>): ArrayList<SelectionItem> {
        return strings.map { SelectionItem(it) } as ArrayList<SelectionItem>
    }

}