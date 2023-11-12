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
        initRecycler()
        viewModel.liveData.observe(viewLifecycleOwner) {
            onDataReceived(it)
        }
        viewModel.loadData()
    }

    private fun onDataReceived(jokesCategories: UiState<List<String>?>?) {
        when(jokesCategories) {
            is UiState.Success -> {
                binding.sampleRecycler.visibility = View.VISIBLE
                binding.sampleProgress.visibility = View.GONE
                binding.errorImage.visibility = View.GONE
                binding.errorTitle.visibility = View.GONE
                binding.errorSubtitle.visibility = View.GONE
                jokesCategories.value?.let { adapter.submitList(it) }
            }
            is UiState.Failure -> {
                binding.sampleRecycler.visibility = View.GONE
                binding.sampleProgress.visibility = View.GONE
                binding.errorImage.visibility = View.VISIBLE
                binding.errorTitle.visibility = View.VISIBLE
                binding.errorSubtitle.visibility = View.VISIBLE
                binding.errorSubtitle.text = jokesCategories.message
            }
            is UiState.Loading -> {
                binding.sampleRecycler.visibility = View.GONE
                binding.sampleProgress.visibility = View.VISIBLE
                binding.errorImage.visibility = View.GONE
                binding.errorTitle.visibility = View.GONE
                binding.errorSubtitle.visibility = View.GONE
            }
            else -> {}
        }
    }

    private fun initRecycler() = with(binding.sampleRecycler) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = this@SampleFragment.adapter
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }
}