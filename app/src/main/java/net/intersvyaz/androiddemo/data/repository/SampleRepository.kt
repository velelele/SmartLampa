package net.intersvyaz.androiddemo.data.repository

interface SampleRepository {
    suspend fun getJokesCategories(): Result<List<String>?>

    suspend fun getColors(): Result<List<String>?>

    suspend fun turnOnLamp(): Result<Boolean?>

    suspend fun turnOffLamp(): Result<Boolean?>
}

