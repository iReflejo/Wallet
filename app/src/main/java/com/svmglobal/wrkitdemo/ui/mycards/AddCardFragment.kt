package com.svmglobal.wrkitdemo.ui.mycards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.svmglobal.wrkitdemo.R
import com.svmglobal.wrkitdemo.databinding.AddCardFragmentBinding

class AddCardFragment : Fragment() {
    val args: AddCardFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AddCardFragmentBinding>(
            inflater,
            R.layout.add_card_fragment,
            container,
            false
        )

        binding.viewModel = args.card
        return binding.root
    }
}