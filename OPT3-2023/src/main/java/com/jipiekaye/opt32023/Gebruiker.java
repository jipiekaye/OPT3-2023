package com.jipiekaye.opt32023;

public class Gebruiker {

    private String naam;
    private String wachtwoord;
    private boolean wiltPopUps;
    private int aantalVoltooideTaken;

    public Gebruiker(String naam, String wachtwoord, boolean wiltPopUps) {
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.wiltPopUps = wiltPopUps;
        this.aantalVoltooideTaken = 0;
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
}
