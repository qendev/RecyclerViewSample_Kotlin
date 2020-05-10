 package com.example.recyclerviewsample_kotlin

import activities.FavoriteActivity
import activities.RecentlyPlayedActivity
import adapters.SampleAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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


     override fun onCreateOptionsMenu(menu: Menu): Boolean {
         val inflater: MenuInflater = menuInflater
         inflater.inflate(R.menu.song_menu, menu)
         return true
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         // Handle item selection
         return when (item.itemId) {
             R.id.recently_played -> {
                 val intent = Intent(this, RecentlyPlayedActivity::class.java)
                 startActivity(intent)
                 true
             }
             R.id.favorite -> {
                 val intent = Intent(this, FavoriteActivity::class.java)
                 startActivity(intent)
                 true
             }
             else -> super.onOptionsItemSelected(item)
         }
     }
}
