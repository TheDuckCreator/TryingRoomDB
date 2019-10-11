package th.`in`.theduckcreator.androiddatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Creating Database
 * Database Require Entities Argument to show Construction that Database is for?
 * */

@Database(entities = [SleepDatabase::class],version = 1,exportSchema = false)
abstract class SleepDatabase:RoomDatabase(){
    abstract val sleepDatabaseDao:SleepDatabaseDao
    /** Companion Object is object that allow client to access method
     * for creating or getting database without instantiationg class */
    companion object{
        /** Create a private nullable Variable INSTANCE for database and initial it to null
         * INSTANCE Variable will keep a reference to database once one has created
         *
         * Annotate INSTANCE as @Volatile / Volatile will newveer by cached
         * (not on cache) it only on the main memeory
         * This make sure that Value in INSTANCE is up-to-date
         * */
        @Volatile
        private var INSTANCE: SleepDatabase? = null

        fun getInstance(context:Context):SleepDatabase{
            /** Multiple Thread cannot access to DB at the Same time*/
            synchronized(this){
                //smart cast : Copy Current Value
                var instance = INSTANCE
                // if instance exits don't create again return this but if not Create the Database
                /** Migration Object is an Object that define how take all row with old schema
                 * and Convert them to rows in new Schema
                 * Migration  make your data not loss
                 *
                 * But in this lab We don't use migration,if anything change?? destroy and rebuild
                 * */

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SleepDatabase::class.java,
                        "sleep_history_database").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }
}