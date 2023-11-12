package net.intersvyaz.androiddemo.presenter.sample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.intersvyaz.androiddemo.domain.GetJokesCategoriesUseCase
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    private val getJokesCategoriesUseCase: GetJokesCategoriesUseCase,
): ViewModel() {

    private val _liveData = MutableLiveData<List<String>>()
    val liveData: LiveData<List<String>>
        get() = _liveData

    fun loadData() {
        viewModelScope.launch {
            val jokesCategoriesResult = getJokesCategoriesUseCase()
            Log.d("JokesCategories", jokesCategoriesResult.toString())
            if (jokesCategoriesResult.isSuccess) {
                val jokesCategories = jokesCategoriesResult.getOrNull()
                _liveData.postValue(jokesCategories)
            }
        }
    }
}
