package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.kotlin.adapter.TitleFragmentPagesAdapter
import com.example.kotlin.fragment.*
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_tab.view.*

class MainActivity : AppCompatActivity() {
    private val mFragments = ArrayList<Fragment>()
    private var mTitles = arrayOf("首页", "项目", "广场", "公众号", "我")
    private var mIcons = arrayOf(
        R.drawable.tab_home_selected,
        R.drawable.tab_pro_selected,
        R.drawable.tab_activity_selected,
        R.drawable.tab_public_selected,
        R.drawable.tab_me_selected
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setItem()
    }

    private fun setItem() {
        for (i in mTitles.indices) {
            tb.getTabAt(i)?.text = mTitles[i]
        }
    }

    private fun initView() {
        mFragments.add(HomeFragment())
        mFragments.add(ProjectFragment())
        mFragments.add(LiveFragment())
        mFragments.add(WechatFragment())
        mFragments.add(AboutMeFragment())

        val adapter = TitleFragmentPagesAdapter(mFragments, supportFragmentManager)
        vp.offscreenPageLimit = 5
        vp.adapter = adapter
        tb.setupWithViewPager(vp)
        for (i in mTitles.indices) { // 循环添加自定义的tab
            val tab: TabLayout.Tab? = tb.getTabAt(i)
            println("====$i")
            tab?.customView = getTabView(i)
        }

    }

    private fun getTabView(i: Int): View? {

        layoutInflater.inflate(R.layout.item_tab, tb, false).apply {
            this.tab_image.setImageResource(mIcons[i])
            this.tab_text.text = mTitles[i]
            print("------" + mTitles[i])
            return this
        }
    }


}