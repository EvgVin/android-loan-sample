package com.evgvin.loan.ui.application_steps

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.evgvin.loan.data.model.Question
import com.evgvin.loan.ui.application_steps.single_selection.SingleSelectionFragment
import com.evgvin.loan.ui.application_steps.single_selection.SingleSelectionFragmentArgs
import com.evgvin.loan.util.initArguments

class ApplicationAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {

    enum class Type {
        SINGLE_SELECTION
    }

    private val questionsList = ArrayList<Question>()
    private val fragmentsList = ArrayList<Fragment>()

    override fun getCount() = questionsList.size

    override fun getItem(position: Int): Fragment {
        if (position > fragmentsList.size - 1) setupFragmentForQuestion(position)
        return fragmentsList[position]
    }

    private fun setupFragmentForQuestion(position: Int) {
        fragmentsList += when (questionsList[position].type) {
            else -> {
                val args = SingleSelectionFragmentArgs.Builder(questionsList[position].id).build().toBundle()
                SingleSelectionFragment().initArguments(args)
            }
        }
    }

    fun refreshQuestions(newQuestions: List<Question>) {
        questionsList.clear()
        questionsList += newQuestions
        notifyDataSetChanged()
    }

}