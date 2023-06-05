package com.jipiekaye.opt32023;
import javafx.scene.paint.Color;

import java.util.ArrayList;
public class Gebruiker {

    private String naam;
    private String wachtwoord;
    private boolean wiltPopUps;
    private int aantalVoltooideTaken;
    private ArrayList<Taak> taken = new ArrayList<>();

    private int experience;

    public Gebruiker(String naam, String wachtwoord, boolean wiltPopUps) {
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.wiltPopUps = wiltPopUps;
        this.aantalVoltooideTaken = 0;
        this.experience = 0;
    }


    public String getNaam() {
        return naam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public boolean isWiltPopUps() {
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


}
