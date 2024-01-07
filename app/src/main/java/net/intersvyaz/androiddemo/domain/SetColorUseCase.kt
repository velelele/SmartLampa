package net.intersvyaz.androiddemo.domain

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Result<Boolean?>
}