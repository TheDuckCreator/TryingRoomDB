package th.`in`.theduckcreator.database

import th.`in`.theduckcreator.androiddatabase.SleepNight
import androidx.room.Dao
import androidx.room.Insert

@Dao
interface SleepDatabaseDao{
    @Insert
        fun insert(night: SleepNight)
}