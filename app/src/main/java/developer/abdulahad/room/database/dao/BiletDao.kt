package developer.abdulahad.room.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import developer.abdulahad.room.database.entity.Bilet

@Dao
interface BiletDao {

    @Insert
    fun addBilet(bilet: Bilet)

    @Query("select * from bilet")
    fun getAllBilet():List<Bilet>
}