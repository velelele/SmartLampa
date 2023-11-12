package net.intersvyaz.androiddemo.data.repository

interface SampleRepository {
    suspend fun getJokesCategories(): Result<List<String>?>
}

