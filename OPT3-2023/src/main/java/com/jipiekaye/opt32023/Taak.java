package com.jipiekaye.opt32023;

import java.util.Date;

public class Taak {
    private String Titel;
    private Date Duedate;
    private Melding melding;
    private int prioriteit;

    public Taak(String titel, Date duedate, Melding melding, int prioriteit) {
        Titel = titel;
        Duedate = duedate;
        this.melding = melding;
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
