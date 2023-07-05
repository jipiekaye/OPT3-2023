package com.jipiekaye.opt32023;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Brainbuddy extends Application {

    private static final ArrayList<Gebruiker> gebruikers = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        initialiseerProgramma();
        while(true) {
            if (showMenu() == 5)
                break;
        }
    }

    private void initialiseerProgramma() {
        gebruikers.add(new Gebruiker("admin", "admin", true));
    }

    public static void main(String[] args) {
        launch();
    }

    public static int showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Welkom bij BrainBuddy, Hier uw keuzemenu:\n" +
                "1) Toon taken\n" +
                "2) Voeg taak toe\n" +
                "3) Pas Taak aan\n" +
                "4) Verwijder Taak\n" +
                "5) Verlaat programma\n" +
                        "\n" +
                "   Uw Keuze :");
        return scanner.nextInt();
    }
}