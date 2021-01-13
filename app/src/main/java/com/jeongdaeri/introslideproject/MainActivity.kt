package com.jeongdaeri.introslideproject

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "로그"
    }

    private var pageItemList = ArrayList<PageItem>()
    private lateinit var myIntroPagerRecyclerAdapter: MyIntroPagerRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        previous_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - 이전 버튼 클릭")

            my_intro_view_pager.currentItem = my_intro_view_pager.currentItem - 1
        }

        next_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - 다음 버튼 클릭")
            my_intro_view_pager.currentItem = my_intro_view_pager.currentItem + 1
        }

        pageItemList.add(PageItem(R.color.colorOrange, R.drawable.ic_pager_item_1, "하루질문에 답해주세요"))
        pageItemList.add(PageItem(R.color.colorWhite, R.drawable.ic_pager_item_2, "나만의 캐릭터를 키워보세요"))
        pageItemList.add(PageItem(R.color.colorOrange, R.drawable.ic_pager_item_3, "과거의 나를 열람해 보세요"))

        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)

        if (Build.VERSION.SDK_INT < 16) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        actionBar?.hide()


        my_intro_view_pager.apply {

            adapter = myIntroPagerRecyclerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL



            dots_indicator.setViewPager2(this)
        }

    }

}
