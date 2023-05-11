package com.jipiekaye.opt32023;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BrainbuddyController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}