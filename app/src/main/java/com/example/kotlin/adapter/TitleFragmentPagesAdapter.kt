package com.example.kotlin.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter

class TitleFragmentPagesAdapter(
    var fmList: List<androidx.fragment.app.Fragment>,
    fm: androidx.fragment.app.FragmentManager
) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fmList[position]
    }

    override fun getCount(): Int {
        print("zhy===="+fmList.size)
        return fmList.size
    }


}