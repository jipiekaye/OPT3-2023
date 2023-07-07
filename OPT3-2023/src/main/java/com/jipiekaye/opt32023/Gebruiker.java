package com.jipiekaye.opt32023;

import com.jipiekaye.opt32023.TemplateMethodPattern.ConstanteTaak;
import com.jipiekaye.opt32023.TemplateMethodPattern.EnkeleTaak;
import com.jipiekaye.opt32023.TemplateMethodPattern.Taak;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Gebruiker {

    private String naam;
    private String wachtwoord;
    private boolean wiltPopUps;
    private int aantalVoltooideTaken;
    private ArrayList<Taak> taken = new ArrayList<>();

    private Klok klok;

    private int experience;

    public Gebruiker(String naam, String wachtwoord, boolean wiltPopUps) {
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.wiltPopUps = wiltPopUps;
        this.aantalVoltooideTaken = 0;
        this.experience = 0;
        setKlok();
        addTask();
    }

    private void setKlok() {
        Thread thread = new Thread(this.klok = new Klok());
        thread.start();
    }

    private void addTask() {
        taken.add(new EnkeleTaak("medicatie nemen", this.klok, klok.getDatum(), klok.getTijd().substring(0,6)+"10", 1));
        taken.add(new EnkeleTaak("medicatie nemen", this.klok, klok.getDatum(), klok.getTijd().substring(0,6)+"20", 1));
        taken.add(new EnkeleTaak("medicatie nemen", this.klok, klok.getDatum(), klok.getTijd().substring(0,6)+"30", 1));
        taken.add(new EnkeleTaak("medicatie nemen", this.klok, klok.getDatum(), klok.getTijd().substring(0,6)+"40", 1));
        taken.add(new EnkeleTaak("medicatie nemen", this.klok, klok.getDatum(), klok.getTijd().substring(0,6)+"50", 1));
        taken.add(new EnkeleTaak("medicatie nemen", this.klok, klok.getDatum(), klok.getTijd().substring(0,6)+"60", 1));

        taken.add(new ConstanteTaak("neem een slokje water elke 5 seconden.", this.klok, 5, 2));
        System.out.println(takenVanVandaag());
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

    public boolean getWiltPopUps() {
        return wiltPopUps;
    }

    public int getAantalVoltooideTaken() {
        return aantalVoltooideTaken;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void setWiltPopUps(boolean wiltPopUps) {
        this.wiltPopUps = wiltPopUps;
    }

    public void setAantalVoltooideTaken(int aantalVoltooideTaken) {
        this.aantalVoltooideTaken = aantalVoltooideTaken;
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
                result += t.toString();
            }
        }
        return result;
    }

    public void verwijderTaak() {
        Scanner scanner = new Scanner(System.in);

        if (getTaken().isEmpty()) {
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
        System.out.println("Welk type taak wilt u toevoegen?");
        System.out.println("1) Enkele Taak");
        System.out.println("2) Constante taak");
        int optie;
        for (optie = scanner.nextInt(); optie > 2 || optie < 1; optie = scanner.nextInt()) {
            System.out.println("Vul a.u.b. een keuze 1 t/m 2 in.");
        }
        if (optie == 1) {
            taken.add(maakEnkeleTaak());
        }
    }

    private Taak maakEnkeleTaak() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Naam van de taak: ");
        String titel = scanner.next();
        System.out.print("Datum van deadline (" + klok.getDatum() + "): ");
        String datum = scanner.next();
        System.out.print("Tijd van de deadline (" + klok.getTijd() + "): ");
        String tijd = scanner.next();
        System.out.print("Prioriteitsniveau van Taak");
        int prioriteit = scanner.nextInt();
        return new EnkeleTaak(titel, klok, datum, tijd, prioriteit);
    }

    public void toonTaken() {
        int i = 0;
        for (Taak taak: taken) {
            System.out.println(i + ") " + taak.toString());
            i++;
        }
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
}
