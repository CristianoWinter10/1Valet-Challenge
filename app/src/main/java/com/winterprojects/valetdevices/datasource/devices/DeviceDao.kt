package com.winterprojects.valetdevices.datasource.devices

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.winterprojects.valetdevices.domain.devices.entities.DeviceFavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {
    @Query("SELECT * FROM DeviceFavorites")
    suspend fun fetchAll(): List<DeviceFavoriteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upInsert(deviceFavoriteEntity: DeviceFavoriteEntity): Long

    @Delete
    suspend fun delete(deviceFavoriteEntity: DeviceFavoriteEntity)

    @Query(
        """
            SELECT 
              case when count(*) > 0 THEN 1
              else 0 END AS isFavorite 
            FROM 
                DeviceFavorites
            WHERE
                id = :deviceId
        """
    )
    fun checkIsFavorite(deviceId: String): Flow<Boolean>
}