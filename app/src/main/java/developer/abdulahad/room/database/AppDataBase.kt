package developer.abdulahad.room.database

import android.content.Context
import androidx.room.*
import developer.abdulahad.room.database.dao.BiletDao
import developer.abdulahad.room.database.entity.Bilet
@Database(entities = [Bilet::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun biletDuo():BiletDao
    companion object{
        var appDataBase: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context): AppDataBase {
            if (appDataBase ==null){
                appDataBase = Room.databaseBuilder(context, AppDataBase::class.java,"bilet_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return appDataBase!!
        }
    }
}