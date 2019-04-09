package com.evgvin.loan.ui.verification_steps.occupation

import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.evgvin.loan.data.model.Occupation
import com.evgvin.loan.data.repository.OccupationRepository
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OccupationViewModel @Inject constructor(
    private val occupationRepository: OccupationRepository
) : StepViewModel() {

    val occupationName: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    val isValidOccupation = !occupationName.get().isNullOrEmpty()
                    enabledNextStepEvent.value = isValidOccupation
                }
            })
        }
    }

    val occupationsList = MutableLiveData<List<Occupation>>()

    val dataLoading = ObservableBoolean(false)

    init {
        loadOccupationsList()
    }

    private fun loadOccupationsList() {
        dataLoading.set(true)
        compositeDisposable.add(occupationRepository.loadOccupationsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { dataLoading.set(false) }
            .subscribe {
                occupationsList.value = it
            })
    }

}