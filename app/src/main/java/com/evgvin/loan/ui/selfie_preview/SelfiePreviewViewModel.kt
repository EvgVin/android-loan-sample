package com.evgvin.loan.ui.selfie_preview

import androidx.databinding.ObservableField
import com.evgvin.loan.data.repository.UserRepository
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import java.io.File
import javax.inject.Inject

class SelfiePreviewViewModel @Inject constructor(userRepository: UserRepository) : BaseViewModel() {

    val savedAvatarFile = ObservableField<File>(userRepository.avatarFile.value)

    val retakeEvent = SingleLiveEvent<Void>()
    val usePhotoEvent = SingleLiveEvent<Void>()

    fun onRetakeClick() = retakeEvent.call()

    fun onUsePhotoClick() = usePhotoEvent.call()

}