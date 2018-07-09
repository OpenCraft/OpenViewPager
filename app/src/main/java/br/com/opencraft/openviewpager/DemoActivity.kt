package br.com.opencraft.openviewpager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        pager.adapter = MyPagerAdapter(this)
        pager.offscreenPageLimit = 2
        pager.setPageTransformer(true, VerticalParallaxPageTranformer())
    }
}
