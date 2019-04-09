package com.evgvin.loan.ui.home.profile

import androidx.databinding.*
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ProfileViewModel @Inject constructor() : BaseViewModel() {

    val dataLoading = ObservableBoolean(false)
    val isLoanApplied = ObservableBoolean(false)

    val scoreRating: ObservableInt by lazy {
        ObservableInt().apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    val ratingPercentage =  scoreRating.get() / maxScoreRating.get().toFloat()
                    scoreRatingPercentage.set(ratingPercentage)
                }
            })
        }
    }

    val scoreRatingPercentage = ObservableFloat()
    val maxScoreRating = ObservableInt()
    val loanDescription = ObservableField<String>()

    val seeMoreEvent = SingleLiveEvent<Void>()
    val repayEvent = SingleLiveEvent<Void>()
    val applyLoanEvent = SingleLiveEvent<Void>()
    val increaseScoreEvent = SingleLiveEvent<Void>()

    init {
        // Used only for tests
        // ToDo: delete it after connecting to the server
        AndroidSchedulers.mainThread().scheduleDirect({
            maxScoreRating.set(1000)
            scoreRating.set(630)
        }, 2, TimeUnit.SECONDS)
    }

    fun onSeeMoreClick() = seeMoreEvent.call()

    fun onRepayClick() = repayEvent.call()

    fun onApplyLoanClick() = applyLoanEvent.call()

    fun onIncreaseClick() = increaseScoreEvent.call()

}