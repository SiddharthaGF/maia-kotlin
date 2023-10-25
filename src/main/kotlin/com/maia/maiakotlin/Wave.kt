package com.maia.maiakotlin

import javafx.scene.image.PixelWriter
import javafx.scene.paint.Color
import kotlin.math.sin
import kotlin.math.sqrt

class Wave : Vector() {

    var w: Double = 0.0
    var v: Double = 0.0
    var m: Double = 0.0
    var t: Double = 0.0
    var steps: Int = 1

    var palette: List<Color> = mutableListOf()

    fun simpleWave(canvas: PixelWriter) {
        for (j in 0 until 540 step 1) {
            val y = cardY(j)
            for (i in 0 until 700 step 1) {
                val x = cardX(i)
                var z = w * (sqrt((x - x0) * (x- x0) + (y - y0) * (y - y0)) - v * t);
                z = m * sin(z) + 1
                canvas.setColor(i, j, palette[(z * 7.5).toInt()])
            }
        }
    }
}