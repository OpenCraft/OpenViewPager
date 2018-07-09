package br.com.opencraft.openviewpager

import android.support.v4.view.ViewPager
import android.view.View

class VerticalParallaxPageTranformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.translationX = page.width * -position

        when {
            position < -1 -> // This page is way off-screen to the left (or up)
                page.alpha = 0f
            position <= 1 -> { //Next Page
                page.alpha = 1f

                // set Y position to swipe in from top
                val yPosition = position * page.height
                page.translationY = yPosition
                setYParallaxPositionAndScale(page, position)
            }
            else -> {
                val yPosition = position * page.height
                page.translationY = yPosition
                page.findViewById<View>(R.id.highlight)?.let {
                    it.translationY = -it.top.toFloat()
                    it.scaleX = 0.75f
                    it.scaleY = 0.75f
                    it.alpha = 0.5f
                }

            }
        }
    }

    private fun setYParallaxPositionAndScale(page: View, position: Float) {
        val highlight = page.findViewById<View>(R.id.highlight)
        highlight?.let {
            val scale = Math.min(0.75f + (1 - position) * 0.25f, 1f)
            it.scaleX = scale
            it.scaleY = scale
            it.alpha = 1.5f - position
            if (position >= 0)
                it.translationY = position * -it.top.toFloat()
        }

    }
}