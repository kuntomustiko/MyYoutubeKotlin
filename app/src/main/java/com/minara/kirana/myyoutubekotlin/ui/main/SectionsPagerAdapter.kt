package com.minara.kirana.myyoutubekotlin.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.minara.kirana.myyoutubekotlin.R
import com.minara.kirana.myyoutubekotlin.ui.fragment.DestinationFragment
import com.minara.kirana.myyoutubekotlin.ui.fragment.FootballFragment
import com.minara.kirana.myyoutubekotlin.ui.fragment.TravellerFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

// TODO 0 pilih new Tabbed Activity ketika awal membuat project
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {


    // TODO 3,4 menentukan posisi dari setiap fragment di tab
    override fun getItem(position: Int): Fragment {

        var fragment = Fragment()
        when(position){
            0 -> fragment = FootballFragment()
            1 -> fragment = TravellerFragment()
            2 -> fragment = DestinationFragment()
        }

        return fragment
    }

    // TODO 5 menentukan title judul dari setiap posisi fragment
    override fun getPageTitle(position: Int): CharSequence? {
        var titleTab = ""
        when(position){
            0 -> titleTab = "Football"
            1 -> titleTab = "Traveller"
            2 -> titleTab = "Destination"
        }

        return titleTab

    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}