package br.com.opencraft.openviewpager

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MyPagerAdapter(val context: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)

        val view = when (position) {
            0 -> {
                inflater.inflate(R.layout.red_view, container, false)
            }
            1 -> {
                inflater.inflate(R.layout.gray_view, container, false)
            }
            else -> {
                inflater.inflate(R.layout.blue_view, container, false)
            }
        }
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return 3
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?)
    }
}