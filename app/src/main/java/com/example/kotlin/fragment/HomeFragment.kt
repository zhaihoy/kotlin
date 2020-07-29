package com.example.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin.R
import com.example.kotlin.bean.BannerBean
import com.example.kotlin.fragment.presenter.HomePresenter

//MVP
@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment(), homeViewlml {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_collection, null)
        initBanner()
        return mView
    }

    private fun initBanner() {
        val homePresenter = HomePresenter(HomeFragment())
        homePresenter.loadBanner()

    }

    override fun showBanner(mData: MutableList<BannerBean>) {
        for (i in mData.indices) {
            print(mData[i].imagePath)
        }
    }
}
