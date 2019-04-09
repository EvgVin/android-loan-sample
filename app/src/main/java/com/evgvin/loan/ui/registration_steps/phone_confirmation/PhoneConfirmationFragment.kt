package com.evgvin.loan.ui.registration_steps.phone_confirmation

import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentPhoneConfirmationBinding
import com.evgvin.loan.ui.steps_container.step.StepFragment
import com.evgvin.loan.util.getColor

open class PhoneConfirmationFragment : StepFragment<FragmentPhoneConfirmationBinding, PhoneConfirmationViewModel>() {

    val HELPER_AND_CAPTION_DIVIDER = " "

    override lateinit var viewModel: PhoneConfirmationViewModel

    override fun getLayoutId() = R.layout.fragment_phone_confirmation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PhoneConfirmationViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupHelperText()
    }

    private fun setupHelperText() {
        val helperText = resources.getString(R.string.phone_confirmation_helper) + HELPER_AND_CAPTION_DIVIDER
        val captionText = resources.getString(R.string.phone_confirmation_helper_caption)
        val spannableString = SpannableStringBuilder(helperText)

        val spannableCaption = SpannableString(captionText)
        val clickableCaption = object : ClickableSpan() {
            override fun onClick(view: View) {
                viewModel.onSendAgainClick()
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

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = PhoneConfirmationFragmentDirections.showPinCreation()
    }

}