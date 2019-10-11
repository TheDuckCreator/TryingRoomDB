package th.`in`.theduckcreator.androiddatabase
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "daily_sleep_quality_table")
data class SleepNight(

    /**
     * 1. Make your Entity not Data Access Object (DAO)
     * Initiate All Value and Annotate Primary Key at primary Key Value
     * the Remainding Annotate with @CloumnInfo
     * */

    @PrimaryKey(autoGenerate = true)
    var nightId: Long = 0L,

    @ColumnInfo(name="start_time_milli")
    val startTimeMilli:Long = System.currentTimeMillis(),

    @ColumnInfo(name="end_time_milli")
    var endtimeMilli: Long = startTimeMilli,

    @ColumnInfo(name="quality_rating")
    var sleepQuality: Int = -1
)