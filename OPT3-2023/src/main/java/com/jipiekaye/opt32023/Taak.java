package com.jipiekaye.opt32023;

import java.util.Date;

public class Taak {
    private String Titel;
    private Melding melding;
    private int prioriteit;

    public Taak(String titel, Klok klok, String deadlineDatum, String deadlineTijd, int prioriteit) {
        Titel = titel;
        this.melding = new Melding(titel, klok, deadlineDatum, deadlineTijd);
        this.prioriteit = prioriteit;
    }

    public Taak(String titel, Klok klok, String deadlineDatum, int prioriteit) {
        Titel = titel;
        this.melding = new Melding(titel, klok, deadlineDatum, "12:00:00");
        this.prioriteit = prioriteit;
    }

    public static int experienceCalculator(int prioriteit, boolean teLaat, int dagenTeVroeg, boolean laatsteTaak) {
        double result = (double) 100 / prioriteit;
        if (dagenTeVroeg > 0)
            result *= (dagenTeVroeg * 1.5);
        if (teLaat)
            result /= 2;
        if (laatsteTaak)
            result += 50;
        return (int) result;
    }
}
