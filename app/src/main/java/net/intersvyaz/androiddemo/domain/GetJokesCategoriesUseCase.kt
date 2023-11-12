package net.intersvyaz.androiddemo.domain

interface GetJokesCategoriesUseCase {
    suspend operator fun invoke(): Result<List<String>?>
}

