package com.maia.maiakotlin

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.fxml.FXML
import javafx.scene.image.ImageView
import javafx.scene.image.PixelWriter
import javafx.scene.image.WritableImage
import javafx.scene.paint.Color
import javafx.util.Duration


class HelloController {

    private val image = WritableImage(700, 540)
    private val canvas: PixelWriter = image.pixelWriter

    private val palette0: List<Color> = listOf(
        Color.BLACK,
            Color.NAVY,
            Color.GREEN,
            Color.AQUA,
            Color.RED,
            Color.PURPLE,
            Color.MAROON,
            Color.LIGHTGREY,
            Color.DARKGRAY,
            Color.BLUE,
            Color.LIME,
            Color.SILVER,
            Color.TEAL,
            Color.FUCHSIA,
            Color.YELLOW,
            Color.WHITE
    )

    @FXML
    private lateinit var screen: ImageView

    @FXML
    private fun onDoSomething() {

        val wave = Wave()
        wave.palette = palette0
        wave.w = 1.5
        wave.v = 9.3
        wave.t = 0.0
        wave.m = 1.0
        wave.x0 = 0.0
        wave.y0 = -6.15

        val duration = Duration.millis(60.0)

        val keyFrame = KeyFrame(duration, {
            wave.simpleWave(canvas)
            screen.image = image
            wave.t += 0.01

        })

        val timeline = Timeline(keyFrame)
        timeline.cycleCount = 200
        timeline.play()
    }
}