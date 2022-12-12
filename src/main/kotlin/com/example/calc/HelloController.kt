package com.example.calc

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.AnchorPane
import kotlin.math.asin
import kotlin.math.atan
import kotlin.math.sqrt


class HelloController {
    @FXML
    private lateinit var angle_big: TextField
    @FXML
    private lateinit var angle_small: TextField
    @FXML
    private lateinit var radius_big: TextField
    @FXML
    private lateinit var radius_small: TextField
    @FXML
    private lateinit var length_center: TextField
    @FXML
    private lateinit var length_margin: TextField
    @FXML
    private lateinit var full_length: TextField
    @FXML
    private lateinit var arc_big: TextField
    @FXML
    private lateinit var arc_small: TextField

    @FXML
    private lateinit var  aPane: AnchorPane

    @FXML
    private fun onHelloButtonClick() {
        var bigRadius = radius_big.text.toDouble()
        var smallRadius = radius_small.text.toDouble()
        var lengthcenter = length_center.text.toDouble()

        var lengthmargin  = calculate_length_margin(lengthcenter, bigRadius, smallRadius)
        var arcbig = 2*calculate_arc_big(lengthmargin, bigRadius - smallRadius)
        var arcsmall = 180 + 2*(90 - calculate_arc_big(lengthmargin, bigRadius - smallRadius))
        var arclengthbig = calculate_arc_length(arcbig, bigRadius)
        var arclengthsmall = calculate_arc_length(arcsmall, smallRadius)
        var fulllength = calculat_total_length(lengthmargin, arclengthsmall, arclengthbig)

        length_margin.text = lengthmargin.toString()
        arc_big.text = arclengthbig.toString()
        arc_small.text = arclengthsmall.toString()
        full_length.text = fulllength.toString()
        angle_big.text = arcbig.toString()
        angle_small.text  = arcsmall.toString()
    }

    private fun calculate_length_margin(length:Double, bigRadius :Double, smallRadius: Double): Double {
        return sqrt(length*length + (bigRadius - smallRadius)*(bigRadius - smallRadius))
    }

    private fun calculate_arc_big(oposite: Double, hipotenuse: Double ): Double {
        println(atan(oposite / hipotenuse) * 180 / 3.14)
        return atan(oposite / hipotenuse) * 180 / 3.14
    }

    private fun calculate_arc_length(angle: Double, radius: Double ): Double {
        return (angle/360)* 2 * 3.14 * radius;
    }

    private fun calculat_total_length(lengthMargin:Double, lengthSmallArc :Double, lengthBigArc: Double): Double {
        return 2*lengthMargin + lengthBigArc + lengthSmallArc
    }

}