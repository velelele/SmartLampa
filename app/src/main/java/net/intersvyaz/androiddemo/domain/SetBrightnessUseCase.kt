package net.intersvyaz.androiddemo.domain

interface SetBrightnessUseCase {
    suspend operator fun invoke(level: Int): Result<Boolean?>
}