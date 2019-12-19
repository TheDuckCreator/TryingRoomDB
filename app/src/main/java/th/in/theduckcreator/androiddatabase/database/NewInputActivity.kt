package th.`in`.theduckcreator.androiddatabase.database

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import th.`in`.theduckcreator.androiddatabase.R
import th.`in`.theduckcreator.androiddatabase.SleepNight
import th.`in`.theduckcreator.androiddatabase.databinding.ActivityNewInputBinding

class NewInputActivity : AppCompatActivity() {

    private lateinit var binding:ActivityNewInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_input)
        val saveButton = binding.saveButton
        val editNightID = binding.nightID
        val editStart = binding.startTime
        val editFinish = binding.finishTime
        val editQuality = binding.sleepQuality

        saveButton.setOnClickListener {
            val replyIntent = Intent()
            if(TextUtils.isEmpty(editNightID.text)||
                TextUtils.isEmpty(editStart.text)||
                TextUtils.isEmpty(editFinish.text)||
                TextUtils.isEmpty(editQuality.text)){
                setResult(Activity.RESULT_CANCELED,replyIntent)
            }
            else{
//                val newSleepNight = SleepNight(editNightID.text.toString().toLong(),
//                    editStart.text.toString().toLong(),editFinish.text.toString().toLong(),editQuanlity.text.toString().toInt())
                    replyIntent.putExtra(EXTRA_REPLY,editQuality.text.toString())
//                replyIntent.putExtra(EXTRA_REPLY,newSleepNight)
                setResult(Activity.RESULT_OK,replyIntent)
            }
            finish()
        }

    }
    companion object {
        const val EXTRA_REPLY = "th.in.theduckcreator.androiddatabase.REPLY"
    }
}
