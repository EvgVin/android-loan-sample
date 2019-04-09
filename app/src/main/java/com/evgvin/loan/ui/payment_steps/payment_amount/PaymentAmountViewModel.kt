package com.evgvin.loan.ui.payment_steps.payment_amount

import android.content.Context
import android.text.InputFilter
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.evgvin.loan.R
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import org.koin.ext.isInt
import javax.inject.Inject

class PaymentAmountViewModel @Inject constructor(private val context: Context) : StepViewModel() {

    /**
     * Payment amount filtering.
     * The user enters the necessary amount of money to withdraw.
     */
    val amountFilter = InputFilter { source, _, _, dest, _, _ ->
        if (dest.isNullOrEmpty() && source.isNullOrEmpty()) return@InputFilter source
        val inputText = if (dest.isNullOrEmpty()) source.toString() else dest.toString()
        val inputAmount = if (inputText.isInt()) inputText.toInt() else -1
        if (isValidAmount(inputAmount)) {
            source
        } else {
            ""
        }
    }

    // Used only for tests
    // ToDo: delete it after connecting to the server
    private var minAmount = 1

    // Used only for tests
    // ToDo: delete it after connecting to the server
    private var maxAmount = 100 // Test value
        set(value) {
            helperText.set(String.format(context.getString(R.string.payment_amount_helper), minAmount, value))
            field = value
        }

    val paymentAmount: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    val paymentAmount = if (this@apply.get()?.isInt() == true) this@apply.get()?.toInt() else -1
                    enabledNextStepEvent.value = isValidAmount(paymentAmount ?: -1)
                }
            })
        }
    }

    val helperText = ObservableField<String>()

    init {
        // Used only for tests
        // ToDo: delete it after connecting to the server
        maxAmount = 101
    }

    private fun isValidAmount(amount: Int) = amount in minAmount..maxAmount

}