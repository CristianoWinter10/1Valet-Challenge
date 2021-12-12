package com.winterprojects.valetdevices.presentation.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.valetdevices.business.devices.DeleteDeviceFavoriteUseCase
import com.winterprojects.valetdevices.business.devices.FetchAllDeviceFavoriteUseCase
import com.winterprojects.valetdevices.business.devices.UpInsertDeviceFavoriteUseCase
import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.helpers.StateResult
import kotlinx.coroutines.*

class FavoritesViewModel(
    private val fetchAllDeviceFavoriteUseCase: FetchAllDeviceFavoriteUseCase,
    private val upInsertDeviceFavoriteUseCase: UpInsertDeviceFavoriteUseCase,
    private val deleteDeviceFavoriteUseCase: DeleteDeviceFavoriteUseCase,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private var _lastPositionDeviceFavoriteRemoved: Int = 0

    val lastPositionDeviceFavoriteRemoved: Int
        get() = _lastPositionDeviceFavoriteRemoved

    private lateinit var _lastDeviceFavoriteRemoved: DeviceFavoriteModel

    private var mutableFavorites = MutableLiveData<StateResult<MutableList<DeviceFavoriteModel>>>()

    val favorites: LiveData<StateResult<MutableList<DeviceFavoriteModel>>>
        get() = mutableFavorites

    init {
        viewModelScope.launch {
            withContext(defaultDispatcher) {
                fetchAllDeviceFavoriteUseCase().let { favorites ->
                    mutableFavorites.postValue(favorites)
                }
            }
        }
    }

    fun removeFavoriteItem(position: Int, deviceFavorite: DeviceFavoriteModel) {
        _lastPositionDeviceFavoriteRemoved = position

        favorites.value?.data?.let {
            it.firstOrNull { x -> x.id == deviceFavorite.id }?.let { favShowModel ->
                _lastDeviceFavoriteRemoved = favShowModel
                it.remove(_lastDeviceFavoriteRemoved)
                removeFavoriteItemOnDb()
            }

            if (it.isEmpty()) {
                mutableFavorites.postValue(StateResult.Empty)
            } else {
                mutableFavorites.postValue(StateResult.Loaded(it))
            }
        }

    }

    private fun removeFavoriteItemOnDb() {
        MainScope().launch {
            withContext(defaultDispatcher) {
                deleteDeviceFavoriteUseCase(_lastDeviceFavoriteRemoved)
            }
        }
    }


    fun undoRemoveFavoriteItem() {
        if (!this::_lastDeviceFavoriteRemoved.isInitialized) return

        favorites.value?.data?.let {
            it.add(_lastPositionDeviceFavoriteRemoved, _lastDeviceFavoriteRemoved)

            undoRemoveDeviceFavoriteOnDB()

            mutableFavorites.postValue(StateResult.Loaded(it))
        } ?: run {
            undoRemoveDeviceFavoriteOnDB()

            mutableFavorites.postValue(
                StateResult.Loaded(
                    mutableListOf(
                        _lastDeviceFavoriteRemoved
                    )
                )
            )
        }
    }

    private fun undoRemoveDeviceFavoriteOnDB() {
        MainScope().launch {
            withContext(defaultDispatcher) {
                upInsertDeviceFavoriteUseCase(_lastDeviceFavoriteRemoved)
            }
        }
    }
}