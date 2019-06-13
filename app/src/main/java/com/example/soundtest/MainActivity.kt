package com.example.soundtest

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.libary_layout.view.*
import layout.item_libary

class MainActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    var adapter: MusicAdapter? = null
    var msList = ArrayList<item_libary>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        msList.add(item_libary("alarm_clock", R.drawable.alarm_clock))
        msList.add(item_libary("cat_purr", R.drawable.cat_purr))
        msList.add(item_libary("clown_horn", R.drawable.clown_horn))
        msList.add(item_libary("dog_barking", R.drawable.dog_barking))
        msList.add(item_libary("rain_on_roof", R.drawable.rain_on_roof))
        msList.add(item_libary("strong_wind", R.drawable.strong_wind))
        adapter = MusicAdapter(this, msList)

        msAfterMix.adapter = adapter

        msAfterMix.setOnItemClickListener {parent, view, position, name ->

           val a = msList[position].name
            if(a == "alarm_clock" ) {
                mp = MediaPlayer.create(this,R.raw.alarm_clock)
                mp.start();
            }
            if(a == "cat_purr" ) {
                mp = MediaPlayer.create(this,R.raw.cat_purr)
                mp.start();
            }
            if(a == "clown_horn" ) {
                mp = MediaPlayer.create(this,R.raw.clown_horn)
                mp.start();
            }
            if(a == "dog_barking" ) {
                mp = MediaPlayer.create(this,R.raw.dog_barking)
                mp.start();
            }
            if(a == "rain_on_roof" ) {
                mp = MediaPlayer.create(this,R.raw.rain_on_roof)
                mp.start();
            }
            if(a == "strong_wind" ) {
                mp = MediaPlayer.create(this,R.raw.strong_wind)
                mp.start();
            }






        }


    }
    class MusicAdapter : BaseAdapter {
        var msList = ArrayList<item_libary>()
        var context: Context? = null

        constructor(context: Context, foodsList: ArrayList<item_libary>) : super() {
            this.context = context
            this.msList = foodsList
        }

        override fun getCount(): Int {
            return msList.size
        }

        override fun getItem(position: Int): Any {
            return msList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val music = this.msList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var msView = inflator.inflate(R.layout.libary_layout, null)
            msView.imgMusic.setImageResource(music.image!!)
            msView.msName.text = music.name!!

            return msView
        }
    }
}