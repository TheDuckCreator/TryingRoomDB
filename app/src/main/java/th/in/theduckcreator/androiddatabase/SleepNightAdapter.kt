package th.`in`.theduckcreator.androiddatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Kotlin has Private,Protected,Internal and Public Visibility Modifier
//Internal = Class + Subclass + Inside the Module
// That internal modifier Visibility of constructor
class SleepNightAdapter internal constructor( context: Context):RecyclerView.Adapter<SleepNightAdapter.SleepNightViewHolder>(){
    private val inflater:LayoutInflater = LayoutInflater.from(context)
    private  var sleepNight = emptyList<SleepNight>() // cache copy of SleepNight

    inner class SleepNightViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val sleepNightView:TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepNightViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item,parent,false)
        return SleepNightViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SleepNightViewHolder, position: Int) {
        val current = sleepNight[position]
        holder.sleepNightView.text = current.sleepQuality.toString()
    }

    internal fun setSleepNight(sleepNight: List<SleepNight>){
        this.sleepNight = sleepNight
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return sleepNight.size
    }
}