package net.intersvyaz.androiddemo.domain

interface TurnOffLampUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}