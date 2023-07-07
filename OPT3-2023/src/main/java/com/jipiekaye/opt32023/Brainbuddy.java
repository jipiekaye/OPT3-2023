package com.jipiekaye.opt32023;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Brainbuddy extends Application {
    private static final ArrayList<Gebruiker> gebruikers = new ArrayList<>();
    private Gebruiker huidigeGebruiker;
    private static boolean exit = false;
    @Override
    public void start(Stage stage) throws IOException {
        initialiseerProgramma();
        login();
        doMenu();
    }

    private void initialiseerProgramma() {
        gebruikers.add(new Gebruiker("admin", "admin", true));
    }

    public static void main(String[] args) {
        launch();
    }

    private void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("naam: ");
        String naam = scanner.next();
        System.out.print("wachtwoord: ");
        String wachtwoord = scanner.next();

        for (Gebruiker gebruiker: gebruikers) {
            if (naam.equals(gebruiker.getNaam()) && wachtwoord.equals(gebruiker.getWachtwoord())) {
                huidigeGebruiker = gebruiker;
            } else System.exit(666);
        }
    }

    public void doMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(
                    "Welkom bij BrainBuddy, Hier uw keuzemenu:\n" +
                            "1) Toon taken\n" +
                            "2) Voeg taak toe\n" +
                            "3) Pas Taak aan\n" +
                            "4) Verwijder Taak\n" +
                            "5) Verlaat programma\n" +
                            "\n" +
                            "   Uw Keuze :");
            int optie;
            for (optie = scanner.nextInt(); optie > 5 || optie < 1; optie = scanner.nextInt()) {
                System.out.println("Vul a.u.b. een keuze 1 t/m 5 in.");
            }

            if (optie == 5) {
                break;
            }

            if (optie == 1) {
                huidigeGebruiker.toonTaken();
            }

            if (optie == 2) {
                huidigeGebruiker.voegTaakToe();
            }

            if (optie == 3) {
                huidigeGebruiker.pasTaakAan();
            }

            if (optie == 4) {
                huidigeGebruiker.verwijderTaak();
            }
        }
    }
}