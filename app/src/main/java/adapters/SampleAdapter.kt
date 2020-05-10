package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import classes.SampleItem
import com.example.recyclerviewsample_kotlin.R
import kotlinx.android.synthetic.main.sample_item.view.*

class SampleAdapter(private val sampleList : List<SampleItem>) :RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {

    class SampleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        //to be able to create the caching functionality of the views use constructor
        //first initialize the views
        //views cached inside the viewholders
        val imageView : ImageView = itemView.imageView
        val textView1 : TextView = itemView.textView1
        val textView2 : TextView = itemView.textView2
        val textView3 : TextView = itemView.textView3


    }

    //called by RecyclerView to create new Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        //return one of the sampleView Holder objects
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sample_item,parent,false)
        return SampleViewHolder(itemView)
    }
    //to fill one row with sample data
    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        val currentItem = sampleList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
    }

    //to let the recyclerview know how many items are in the list
    override fun getItemCount() = sampleList.size

}