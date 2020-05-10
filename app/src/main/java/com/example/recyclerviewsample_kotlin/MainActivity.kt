 package com.example.recyclerviewsample_kotlin

import adapters.SampleAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import classes.SampleItem
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //for the total size of the items in the recyclerView
        val sampleList = generateDummyList(800)

        //for passing the adapter into the recyclerView
        recycler_view.adapter = SampleAdapter(sampleList)

        //for positioning items in the recyclerView
        recycler_view.layoutManager = LinearLayoutManager(this)
        //for performance optimization
        recycler_view.setHasFixedSize(true)

    }

    //to generate as many items as required
    private fun generateDummyList(size: Int): List<SampleItem> {

        val list = ArrayList<SampleItem>()

        for (i in 1 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_jam
                1 -> R.drawable.ic_jam
                else -> R.drawable.ic_jam
            }

            val item = SampleItem(drawable, "Song : 'Loren ipsum' $i", "Artist : Loren ipsum", "Album : Loren ipsum ")
            list += item
        }

        return list
    }
}
