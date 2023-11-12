package net.intersvyaz.androiddemo.presenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import net.intersvyaz.androiddemo.R
import net.intersvyaz.androiddemo.databinding.FragmentSampleBinding

class SampleFragment : Fragment(R.layout.fragment_sample) {

    private val binding: FragmentSampleBinding by viewBinding()
    private val viewModel: SampleViewModel by viewModels()

}