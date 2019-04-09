package com.evgvin.loan.ui.application_steps.single_selection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.evgvin.loan.data.model.Answer
import com.evgvin.loan.data.model.Question
import com.evgvin.loan.data.repository.ApplicationRepository
import com.evgvin.loan.ui.item_selection_list.SelectionListViewModel
import javax.inject.Inject

class SingleSelectionViewModel @Inject constructor(
    private val applicationRepository: ApplicationRepository
) : SelectionListViewModel() {

    val currentQuestionId = MutableLiveData<Int>()
    val question: LiveData<Question?> = Transformations.map(currentQuestionId) { applicationRepository.getItem(it) }

    /**
     * Selected value is the user answer on a question.
     */
    fun selectedValuePosition(position: Int) {
        question.value?.let { applicationRepository.setAnswer(Answer(it.id, position)) }
    }

    /**
     * Restores user answer (value) on a question.
     */
    fun restoreSelectedValue(questionId: Int) {
        applicationRepository.getAnswer(questionId)?.let { singleSelectedItemPosition = it.value as Int }
    }

}