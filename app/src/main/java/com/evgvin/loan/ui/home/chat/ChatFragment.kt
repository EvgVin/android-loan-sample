package com.evgvin.loan.ui.home.chat

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Message
import com.evgvin.loan.databinding.FragmentChatBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.util.setupActionBar

class ChatFragment : BaseFragment<FragmentChatBinding, ChatViewModel>(), ChatNavigator {

    override lateinit var viewModel: ChatViewModel

    var rvAdapter: ChatAdapter by autoCleared()

    override fun getLayoutId() = R.layout.fragment_chat

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ChatViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupChatList()
        subscribeToLiveData()
    }

    private fun setupToolbar() {
        viewDataBinding.apply {
            setupActionBar(toolbar, false) {
                setDisplayShowTitleEnabled(false)
            }
            tvToolbarTitle.text = getString(R.string.chat_title)
        }
    }

    private fun setupChatList() {
        rvAdapter = ChatAdapter()
        viewDataBinding.rvChat.apply {
            layoutManager = LinearLayoutManager(this@ChatFragment.context)
            adapter = rvAdapter
        }
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            chatHistory.observe(this@ChatFragment, Observer<List<Message>> {
                it?.let { rvAdapter.refreshList(it) }
            })
        }
    }

}