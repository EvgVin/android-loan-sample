package com.evgvin.loan.util

import android.animation.LayoutTransition
import android.text.InputFilter
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.evgvin.loan.ui.common.DateInputFilter
import com.evgvin.loan.ui.common.DateTextWatcher
import com.google.android.material.bottomnavigation.BottomNavigationView


object BindingUtils {

    @JvmStatic
    @BindingAdapter("visible")
    fun setVisible(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("selectedItemId")
    fun setSelectedItemId(view: BottomNavigationView, @IdRes itemId: Int) {
        view.selectedItemId = itemId
    }

    @JvmStatic
    @BindingAdapter("datePattern")
    fun setDatePattern(view: EditText, pattern: String) {
        view.addTextChangedListener(DateTextWatcher(pattern, view))
        addInputFilter(view, DateInputFilter(pattern))
    }

    @JvmStatic
    @BindingAdapter("inputFilter")
    fun addInputFilter(view: EditText, filter: InputFilter) {
        view.filters += filter
    }

    @JvmStatic
    @BindingAdapter("enableTransition")
    fun enableTransition(parentLayout: ViewGroup, transition: Int) {
        val layoutTransition = LayoutTransition()
        layoutTransition.enableTransitionType(transition)
        parentLayout.layoutTransition = layoutTransition
    }

    @JvmStatic
    @BindingAdapter("imageSource")
    fun setImageSource(imageView: ImageView, source: Any) {
        val context = imageView.context
        Glide.with(context)
            .load(source)
            .transition(withCrossFade())
            .apply(RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true))
            .into(imageView)
    }

}