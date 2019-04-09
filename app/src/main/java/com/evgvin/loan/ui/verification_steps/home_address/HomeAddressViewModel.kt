package com.evgvin.loan.ui.verification_steps.home_address

import android.content.Context
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse
import com.evgvin.loan.data.repository.AddressPredictionsRepository
import com.evgvin.loan.data.repository.UserRepository
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import javax.inject.Inject

open class HomeAddressViewModel @Inject constructor(
    private val context: Context,
    private val addressPredictionsRepository: AddressPredictionsRepository,
    userRepository: UserRepository
) : StepViewModel() {

    open val address = userRepository.homeAddress

    val stateLoading = ObservableBoolean()

    /**
     * Used for state autocomplete text view.
     */
    val statePredictions = MutableLiveData<List<String>>()

    val stateName: ObservableField<String> by lazy {
        createObservableField {
            findAddressPredictions(stateName.get(), TypeFilter.REGIONS) {
                stateLoading.set(true)
                addOnSuccessListener { statePredictions.value = convertPredictionsToStrings(it.autocompletePredictions) }
                addOnCompleteListener { stateLoading.set(false) }
            }
        }
    }

    val cityLoading = ObservableBoolean()

    /**
     * Used for city autocomplete text view.
     */
    val cityPredictions = MutableLiveData<List<String>>()

    val cityName: ObservableField<String> by lazy {
        createObservableField {
            findAddressPredictions(cityName.get(), TypeFilter.CITIES) {
                cityLoading.set(true)
                addOnSuccessListener { cityPredictions.value = convertPredictionsToStrings(it.autocompletePredictions) }
                addOnCompleteListener { cityLoading.set(false) }
            }
        }
    }

    val streetLoading = ObservableBoolean()

    /**
     * Used for street autocomplete text view.
     */
    val streetPredictions = MutableLiveData<List<String>>()

    val streetName: ObservableField<String> by lazy {
        createObservableField {
            findAddressPredictions(streetName.get(), TypeFilter.ADDRESS) {
                streetLoading.set(true)
                addOnSuccessListener { streetPredictions.value = convertPredictionsToStrings(it.autocompletePredictions) }
                addOnCompleteListener { streetLoading.set(false) }
            }
        }
    }

    private fun createObservableField(setupPredictions: () -> Unit): ObservableField<String> {
        return ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    setupPredictions()
                    validateAddress()
                }
            })
        }
    }

    private fun findAddressPredictions(
        input: String?,
        typeFilter: TypeFilter,
        task: Task<FindAutocompletePredictionsResponse>.() -> Unit
    ) {
        addressPredictionsRepository.findAddressPredictions(input, typeFilter, task)
    }

    private fun validateAddress() {
        var isValidAddress = true
        if (stateName.get().isNullOrEmpty() ||
            cityName.get().isNullOrEmpty() ||
            streetName.get().isNullOrEmpty()) {
            isValidAddress = false
        } else {
            address.apply {
                state = stateName.get()
                city = cityName.get()
                street = streetName.get()
            }
        }
        enabledNextStepEvent.value = isValidAddress
    }

    private fun convertPredictionsToStrings(predictions: List<AutocompletePrediction>): List<String> {
        return predictions.map { it.getPrimaryText(null).toString() }
    }

}