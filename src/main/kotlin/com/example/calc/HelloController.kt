package com.example.calc

import javafx.fxml.FXML
import javafx.scene.control.Label

class HelloController {
    @FXML
    private lateinit var angle_big: Label
    private lateinit var full_lentgh: Label
    private lateinit var angle_small: Label

    @FXML
    private fun onHelloButtonClick() {
        full_lentgh.text = "Welcome to JavaFX Application!"
        angle_big.text = "Welcome to JavaFX Application!"
        angle_small.text = "Welcome to JavaFX Application!"
    }



}