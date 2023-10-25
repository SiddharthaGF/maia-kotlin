package com.maia.maiakotlin

import javafx.scene.image.PixelWriter
import javafx.scene.paint.Color as Colors

open class Vector {

    var x0: Double = 0.0
    var y0: Double = 0.0

    var color: Colors = Colors.RED

    data class Coordinates(var x: Double = 0.0, var y: Double = 0.0)
    data class CoordinatesInt(var x: Int = 0, var y: Int = 0)

    companion object {

        val Sx1: Int = 0
        val Sx2: Int = 700
        val Sy1: Int = 0
        val Sy2: Int = 540
        val X1: Double = -8.0
        val Y1: Double = -6.15
        val X2: Double = 8.0
        val Y2: Double = 6.15

        fun screen(x: Double, y: Double, s: CoordinatesInt) {
            s.x = ((x - X1) / (X1 - X2) * (Sx1 - Sx2) + Sx1).toInt()
            s.y = ((x - Y2) / (Y2 - Y1) * (Sy1 - Sy2) + Sy1).toInt()
        }

        fun cardX(xp:Int) : Double {
            return ((xp - Sx1) * ((X1 - X2) / (Sx1 - Sx2)) + X1)

        }

        fun cardY(yp:Int) : Double {
            return ((yp - Sy2) * ((Y1 - Y2) / (Sy2 - Sx1)) + Y1)
        }


    }

    fun on(canvas: PixelWriter) {
        val s = CoordinatesInt()
        screen(x0, y0, s)
        if (s.x in Sx1..Sx2 && s.y in Sy1 .. Sy2)  {
            canvas.setColor(s.x, s.y, color)
        }
    }

}