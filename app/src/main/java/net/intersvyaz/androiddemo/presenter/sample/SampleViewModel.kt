package net.intersvyaz.androiddemo.presenter.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.intersvyaz.androiddemo.UiState
import net.intersvyaz.androiddemo.domain.GetJokesCategoriesUseCase
import net.intersvyaz.androiddemo.domain.TurnOffLampUseCase
import net.intersvyaz.androiddemo.domain.TurnOnLampUseCase
import net.intersvyaz.androiddemo.toUiState
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    private val getJokesCategoriesUseCase: GetJokesCategoriesUseCase,
    private val turnOnLampUseCase: TurnOnLampUseCase,
    private val turnOffLampUseCase: TurnOffLampUseCase
): ViewModel() {

    private val _liveData = MutableLiveData<UiState<List<String>?>>(UiState.Loading)
    val liveData: LiveData<UiState<List<String>?>>
        get() = _liveData

    fun onLamp() {
        viewModelScope.launch {
            turnOnLampUseCase()
        }
    }

    fun offLamp(){
        viewModelScope.launch {
            turnOffLampUseCase()
        }
    }
}
