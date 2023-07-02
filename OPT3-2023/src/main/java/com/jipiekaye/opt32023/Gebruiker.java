package com.jipiekaye.opt32023;

import com.jipiekaye.opt32023.TemplateMethodPattern.ConstanteTaak;
import com.jipiekaye.opt32023.TemplateMethodPattern.EnkeleTaak;

import java.util.ArrayList;
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
}
