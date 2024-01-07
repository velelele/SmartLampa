package net.intersvyaz.androiddemo.presenter.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.intersvyaz.androiddemo.UiState
import net.intersvyaz.androiddemo.domain.GetColorsUseCase
import net.intersvyaz.androiddemo.domain.SetBrightnessUseCase
import net.intersvyaz.androiddemo.domain.SetColorUseCase
import net.intersvyaz.androiddemo.domain.TurnOffLampUseCase
import net.intersvyaz.androiddemo.domain.TurnOnLampUseCase
import net.intersvyaz.androiddemo.toUiState
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    private val turnOnLampUseCase: TurnOnLampUseCase,
    private val turnOffLampUseCase: TurnOffLampUseCase,
    private val setBrightnessUseCase: SetBrightnessUseCase,
    private val getColorsUseCase: GetColorsUseCase,
    private val setColorUseCase: SetColorUseCase,
): ViewModel() {

    private val _colors = MutableLiveData<UiState<List<String>?>>(UiState.Loading)
    val colors: LiveData<UiState<List<String>?>>
        get() = _colors

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

    fun setBrightness(level: Int){
        viewModelScope.launch {
            setBrightnessUseCase(level)
        }
    }

    fun getColors(){
        viewModelScope.launch {
            _colors.postValue(getColorsUseCase().toUiState())
        }
    }

    fun setColor(color: String){
        viewModelScope.launch {
            setColorUseCase(color)
        }
    }
}
