package com.jipiekaye.opt32023;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Brainbuddy extends Application {

    private static final ArrayList<Gebruiker> gebruikers = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        initialiseerProgramma();

        FXMLLoader fxmlLoader = new FXMLLoader(Brainbuddy.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("BrainBuddy");
        stage.setScene(scene);
        stage.show();

    }

    private void initialiseerProgramma() {
        gebruikers.add(new Gebruiker("admin", "admin", true));
    }

    public static void main(String[] args) {
        launch();
    }
}