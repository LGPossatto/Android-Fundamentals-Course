package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator

class SwipableViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipable_view)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<ViewPager2>(R.id.tabLayout)

        val images = listOf(
            R.drawable.kermit01,
            R.drawable.kermit01,
            R.drawable.kermit01,
            R.drawable.kermit01,
            R.drawable.kermit01,
            R.drawable.kermit01,
            R.drawable.kermit01
        )

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter

        // TabLayoutMediator(tabLayout, viewPager) { tab, position ->
        //     tab.text = "Tab ${position + 1}"
        // }.atach()
    }
}