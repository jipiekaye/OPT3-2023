package com.jipiekaye.opt32023;

import com.jipiekaye.opt32023.TemplateMethodPattern.ConstanteTaak;
import com.jipiekaye.opt32023.TemplateMethodPattern.EnkeleTaak;
import com.jipiekaye.opt32023.TemplateMethodPattern.Taak;

import java.util.ArrayList;
import java.util.Scanner;

public class Gebruiker {

    private String naam;
    private String wachtwoord;
    private boolean wiltPopUps = false;
    private ArrayList<Taak> taken = new ArrayList<>();

    private Klok klok;


    public Gebruiker(String naam, String wachtwoord) {
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        setKlok();
    }
    public void intitialiseerStandaardTaken(){
        taken.add(new ConstanteTaak("Medicatie nemen elke 10 seconden", klok, 10, 1));
    }

    private void setKlok() {
        Thread thread = new Thread(this.klok = new Klok());
        thread.start();
    }

    public ArrayList<Taak> getTaken() {
        return taken;
    }

    public String getNaam() {
        return naam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String standVanTaken(int takenTeDoen, int aantalVoltooideTaken) {
        float taken = ((float) aantalVoltooideTaken/(takenTeDoen + aantalVoltooideTaken))*100;
        if (taken < 30)
            return "rood";
        if (taken < 70)
            return "geel";
        else return "groen";
    }

    public String takenVanVandaag() {
        String result = null;
        for (Taak t: taken) {
            if (t.isVandaag()) {
                result += (t.toString()+"\n");
            }
        }
        return result;
    }

    public void verwijderTaak() {
        Scanner scanner = new Scanner(System.in);

        if (!getTaken().isEmpty()) {
            System.out.println("Welke taak wilt u verwijderen?");
            int i = 1;
            for (Taak inhoud : getTaken()) {
                System.out.println(i + ") " + inhoud);
                i++;
            }
            System.out.print("1-" + i + ": ");
            getTaken().remove(scanner.nextInt() - 1);
        }
        else System.out.println("Er zijn geen taken om te verwijderen.");
    }

    public void voegTaakToe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Welk type taak wilt u toevoegen?");
        System.out.println("1) Enkele Taak");
        System.out.println("2) Constante taak");
        System.out.print("   Uw Keuze : ");
        int optie;
        for (optie = scanner.nextInt(); optie > 2 || optie < 1; optie = scanner.nextInt()) {
            System.out.println("Vul a.u.b. een keuze 1 t/m 2 in.");
        }
        if (optie == 1) {
            taken.add(maakEnkeleTaak());
        }
        if (optie == 2) {
            taken.add(maakConstanteTaak());
        }
    }

    private Taak maakConstanteTaak() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Naam van de taak: ");
        String titel = scanner.nextLine();
        System.out.print("hoeveel seconden moeten er tussen elke melding zitten: ");
        int seconden = scanner.nextInt();
        System.out.print("Prioriteitsniveau van Taak: ");
        int prioriteit = scanner.nextInt();
        return new ConstanteTaak(titel, klok, seconden, prioriteit);
    }

    private Taak maakEnkeleTaak() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Naam van de taak: ");
        String titel = scanner.nextLine();
        System.out.print("Datum van deadline (" + klok.getDatum() + "): ");
        String datum = scanner.nextLine();
        System.out.print("Tijd van de deadline (" + klok.getTijd() + "): ");
        String tijd = scanner.nextLine();
        System.out.print("Prioriteitsniveau van Taak: ");
        int prioriteit = scanner.nextInt();
        return new EnkeleTaak(titel, klok, datum, tijd, prioriteit);
    }

    public void toonTaken() {
        if (!taken.isEmpty()) {
            int i = 0;
            for (Taak taak : taken) {
                System.out.println(i + ") " + taak.toString());
                i++;
            }
        }
        else System.out.println("\nEr waren geen taken om te tonen.\n");
    }

    void pasTaakAan() {
//        Scanner scanner = new Scanner(System.in);
//        toonTaken();
//        System.out.println("Welke taak wilt u aanpassen: ");
//        int in;
//        for (in = scanner.nextInt(); in > taken.size() || in < 0; in = scanner.nextInt()) {
//            System.out.println("Vul a.u.b. een keuze 0 t/m "+ taken.size()+ " in.");
//        }
//        Taak taak = taken.get(in);
//        if (taak instanceof EnkeleTaak)
//            enkeleTaak
    }

    public void meldingScherm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wacht voor uw console meldingen, type 'menu' om terug te gaan naar menu:");
        setSchermAan(true);
        while (true) {
            if (scanner.nextLine().equals("menu")) {
                setSchermAan(false);
                break;
            }
        }
    }

    private void setSchermAan(boolean setAllMeldingen) {
        for (Taak taak: taken) {
            taak.setMeldingSchermAan(setAllMeldingen);
        }
    }
}
