package th.`in`.theduckcreator.androiddatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import th.`in`.theduckcreator.androiddatabase.databinding.ActivityMainBinding
import th.`in`.theduckcreator.androiddatabase.database.SleepDatabaseDao

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val sleepButton = binding.btSleep
        sleepButton.setOnClickListener {

        }

    }
}
