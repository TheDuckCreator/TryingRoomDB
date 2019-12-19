package th.`in`.theduckcreator.androiddatabase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import th.`in`.theduckcreator.androiddatabase.database.NewInputActivity
import th.`in`.theduckcreator.androiddatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() ,CoroutineScope by CoroutineScope(Dispatchers.Default) {

    private lateinit var binding:ActivityMainBinding
    private lateinit var sleepViewModel: SleepNightViewModel // Associate ViewModel to Activity
    private val newSleepActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //Bind Adapter to Recycler View
        val recyclerView = binding.recyclerview
        val adapter = SleepNightAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        //Bind ViewModel to Activity
        sleepViewModel= ViewModelProviders.of(this).get(SleepNightViewModel::class.java)
        sleepViewModel.allSleepNight.observe(this, Observer { sleepNights ->
            sleepNights?.let { adapter.setSleepNight(it) }
        })

        val populateButton = binding.floatingActionButton
        populateButton.setOnClickListener {
            val intent = Intent(this@MainActivity,NewInputActivity::class.java)
            startActivityForResult(intent,newSleepActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Request Code == 1 show that it's from MainActivitys
        if(requestCode == newSleepActivityRequestCode && resultCode == Activity.RESULT_OK ){
            data?.getStringExtra(NewInputActivity.EXTRA_REPLY)?.let{
                val sleepNight = SleepNight(it.toLong())
                sleepViewModel.insert(sleepNight)
            }
        }
        else{
            Toast.makeText(
                applicationContext,"Error",Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}
