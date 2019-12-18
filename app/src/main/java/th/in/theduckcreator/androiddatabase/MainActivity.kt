package th.`in`.theduckcreator.androiddatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import th.`in`.theduckcreator.androiddatabase.databinding.ActivityMainBinding
import th.`in`.theduckcreator.androiddatabase.database.SleepDatabaseDao

class MainActivity : AppCompatActivity() ,CoroutineScope by MainScope() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //Bind Adapter to Recycler View
        val recyclerView = binding.recyclerview
        val adapter = SleepNightAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val populateButton = binding.floatingActionButton
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}
