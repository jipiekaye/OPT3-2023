package com.jipiekaye.opt32023;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BrainbuddyController {
    @FXML
    private Label klok;


    @FXML
    protected void onHelloButtonClick() {
        klok.setText(klok.toString());
    }
}