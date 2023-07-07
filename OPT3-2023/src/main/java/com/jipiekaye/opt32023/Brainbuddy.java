package com.jipiekaye.opt32023;


import java.util.ArrayList;
import java.util.Scanner;

public class Brainbuddy {
    private static final ArrayList<Gebruiker> gebruikers = new ArrayList<>();
    private Gebruiker huidigeGebruiker;

    public static void main(String[] args) {
        Brainbuddy application = new Brainbuddy();
        application.initialiseerProgramma();
        application.login();
        application.doMenu();
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

    private void initialiseerProgramma() {
        gebruikers.add(new Gebruiker("admin", "admin"));
        gebruikers.get(0).intitialiseerStandaardTaken();
    }
    public void doMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int optie = getOptie(scanner);

            if (doMenuTask(optie)) System.exit(666);
        }
    }

    private boolean doMenuTask(int optie) {
        if (optie == 5) {
            return true;
        }
        if (optie == 0) {
            huidigeGebruiker.meldingScherm();
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
        return false;
    }

    private int getOptie(Scanner scanner) {
        int optie;
        for (optie = scanner.nextInt(); optie > 5 || optie < 0; optie = scanner.nextInt()) {
            System.out.print("Vul a.u.b. een keuze 0 t/m 5 in: ");
        }
        return optie;
    }

    private void printMenu() {
        System.out.println();
        System.out.print(
                "Hier uw keuzemenu:\n" +
                        "0) ga naar Melding scherm\n" +
                        "1) Toon taken\n" +
                        "2) Voeg taak toe\n" +
                        "3) Pas Taak aan\n" +
                        "4) Verwijder Taak\n" +
                        "5) Verlaat programma\n" +
                        "\n" +
                        "   Uw Keuze : ");
    }
}