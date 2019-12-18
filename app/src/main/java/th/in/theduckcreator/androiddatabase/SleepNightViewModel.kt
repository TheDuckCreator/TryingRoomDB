package th.`in`.theduckcreator.androiddatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import th.`in`.theduckcreator.androiddatabase.database.SleepDatabase

/**
 * ViewModel is to Provide data to UI and serve a configure change
 * ViewModel is center between Repository and UI and can share across fragment
 * */

class SleepNightViewModel(application:Application):AndroidViewModel(application),CoroutineScope by MainScope(){
    //annotate repository that want to use to compiler know
    private  val repository:SleepNightRepository
    val allSleepNight:LiveData<List<SleepNight>>

    init {
        //annotate Dao that want to use and get Instance of Dao from Database
        val sleepNightDao = SleepDatabase.getInstance(application).sleepDatabaseDao
        repository = SleepNightRepository(sleepNightDao)
        allSleepNight = repository.allSleepNight
    }

    fun insert(sleepNight: SleepNight)= MainScope().launch {
        repository.insert(sleepNight)
    }

}