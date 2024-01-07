package net.intersvyaz.androiddemo.domain

interface GetColorsUseCase {
    suspend operator fun invoke(): Result<List<String>?>
}

