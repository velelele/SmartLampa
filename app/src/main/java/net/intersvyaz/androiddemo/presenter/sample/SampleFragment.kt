package net.intersvyaz.androiddemo.presenter.sample

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.SeekBar
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchController()
        seekController()
        viewModel.colors.observe(viewLifecycleOwner){
            spinnerController(it)
        }
        viewModel.getColors()

    }



    private fun spinnerController(colors: UiState<List<String>?>){

        when(colors){
            is UiState.Success ->{
                val colorList = colors.value ?: emptyList()
                val adapter = SpinnerAdapter(requireContext(), colorList)
                binding.spinner.adapter = adapter
            }

            else -> {}
        }
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                viewModel.setColor(selectedItem)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

    }

    private fun seekController(){
        var currentProgress = 0
        val seekBar = binding.seekBar
        seekBar.max = 99

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                currentProgress = progress + 1
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                viewModel.setBrightness(currentProgress)
            }
        })

    }

    private fun switchController() {

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