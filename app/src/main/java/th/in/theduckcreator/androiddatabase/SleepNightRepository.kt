package th.`in`.theduckcreator.androiddatabase

import androidx.lifecycle.LiveData
import th.`in`.theduckcreator.androiddatabase.database.SleepDatabaseDao

/**
 * https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/
 * Repository class is for Multiple data source access.It's the best practice for code separation
 * Repository can use for decide where to fetch data network or offline
 *
 * Define it's Dao as a private property parameters
 * */

class SleepNightRepository (private val sleepNightDao: SleepDatabaseDao){

    /**
     * Room is multithreading program, Observe LiveData will notify when data is changed
     * */

    //Not a private Variable
    val allSleepNight : LiveData<List<SleepNight>> = sleepNightDao.getAllNights()
    fun insert(night: SleepNight){
        sleepNightDao.insert(night)
    }
}