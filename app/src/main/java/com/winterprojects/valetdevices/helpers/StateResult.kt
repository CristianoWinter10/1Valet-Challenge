package com.winterprojects.valetdevices.helpers

sealed class StateResult<out T>(open val data: T? = null) {
    object Loading : StateResult<Nothing>()
    object Empty : StateResult<Nothing>()
    data class Loaded<out T>(override val data: T) : StateResult<T>()
    data class ErrorState(val errorMsg: String?): StateResult<Nothing>()
}