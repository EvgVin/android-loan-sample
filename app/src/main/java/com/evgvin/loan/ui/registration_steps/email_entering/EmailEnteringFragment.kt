package com.evgvin.loan.ui.registration_steps.email_entering

import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentEmailEnteringBinding
import com.evgvin.loan.ui.steps_container.step.StepFragment
import com.evgvin.loan.util.getColor

class EmailEnteringFragment : StepFragment<FragmentEmailEnteringBinding, EmailEnteringViewModel>(),
    EmailEntaringNavigator {

    val HELPER_AND_CAPTION_DIVIDER = " "

    override lateinit var viewModel: EmailEnteringViewModel

    override fun getLayoutId() = com.evgvin.loan.R.layout.fragment_email_entering

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(EmailEnteringViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupHelperText()
        subscribeToLiveData()
    }

    private fun setupHelperText() {
        val helperText = resources.getString(R.string.email_entering_helper) + HELPER_AND_CAPTION_DIVIDER
        val captionText = resources.getString(R.string.email_entering_caption)
        val spannableString = SpannableStringBuilder(helperText)

        val spannableCaption = SpannableString(captionText)
        val clickableCaption = object : ClickableSpan() {
            override fun onClick(view: View) {
                viewModel.onSkipClick()
                view.invalidate()
            }

            override fun updateDrawState(textPaint: TextPaint) {
                textPaint.color = getColor(R.color.captionTextColor)
                textPaint.isUnderlineText = true
            }
        }
        spannableCaption.setSpan(clickableCaption, 0, spannableCaption.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        spannableString.append(spannableCaption)

        viewDataBinding.tvHelper.apply {
            text = spannableString
            movementMethod = LinkMovementMethod.getInstance()
        }
    }

    private fun subscribeToLiveData() {
        viewModel.skipEvent.observe(this, Observer<Void> {
            skip()
        })
    }

    override fun skip() {
        nextStep()
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = EmailEnteringFragmentDirections.showFirstName()
    }

}