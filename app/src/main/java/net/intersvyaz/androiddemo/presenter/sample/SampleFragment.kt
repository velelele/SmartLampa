package net.intersvyaz.androiddemo.presenter.sample

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import net.intersvyaz.androiddemo.R
import net.intersvyaz.androiddemo.UiState
import net.intersvyaz.androiddemo.databinding.FragmentSampleBinding
import net.intersvyaz.androiddemo.di.ViewModelFactory
import net.intersvyaz.androiddemo.di.appComponent
import javax.inject.Inject

class SampleFragment : Fragment(R.layout.fragment_sample) {

    private val binding: FragmentSampleBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: SampleViewModel by viewModels() { viewModelFactory }

    private val adapter = SampleAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start()

    }

    private fun start() {

        binding.ToggleSwitch.setOnCheckedChangeListener{ _ , isChecked ->
            if (isChecked){
                viewModel.onLamp()
                binding.ToggleSwitch.text = "вкл"

            } else {
                viewModel.offLamp()
                binding.ToggleSwitch.text = "выкл"
            }
        }
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }
}