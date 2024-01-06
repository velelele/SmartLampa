package net.intersvyaz.androiddemo.domain

interface TurnOnLampUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}