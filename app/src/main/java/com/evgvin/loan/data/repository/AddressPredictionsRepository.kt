package com.evgvin.loan.data.repository

import android.content.Context
import com.google.android.gms.tasks.Task
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse
import com.google.android.libraries.places.api.net.PlacesClient
import com.evgvin.loan.R
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This repository uses the Google Places API to simplify the entering of the user's address.
 */
@Singleton
class AddressPredictionsRepository @Inject constructor(private val context: Context) {

    private val placesClient: PlacesClient by lazy {
        Places.createClient(context)
    }

    // Create a new token for the autocomplete session. Pass this to FindAutocompletePredictionsRequest,
    // and once again when the user makes a selection (for example when calling fetchPlace()).
    private val token = AutocompleteSessionToken.newInstance()

    init {
        Places.initialize(context, context.getString(R.string.places_api_key));
    }

    fun findAddressPredictions(
        input: String?,
        typeFilter: TypeFilter,
        task: Task<FindAutocompletePredictionsResponse>.() -> Unit
    ) {
        if (input.isNullOrEmpty()) return
        val request = setupAddressRequest(input, typeFilter)
        placesClient.findAutocompletePredictions(request).run {
            task()
        }
    }

    private fun setupAddressRequest(query: String, typeFilter: TypeFilter): FindAutocompletePredictionsRequest {
        return FindAutocompletePredictionsRequest.builder()
            //.setLocationBias(bounds)
            //.setLocationRestriction(bounds)
            //.setCountry("au")
            .setTypeFilter(typeFilter)
            .setSessionToken(token)
            .setQuery(query)
            .build()
    }

}