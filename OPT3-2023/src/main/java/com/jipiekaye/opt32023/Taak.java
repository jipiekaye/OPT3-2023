package com.jipiekaye.opt32023;

import com.jipiekaye.opt32023.Meldingen.ConsoleMelding;
import com.jipiekaye.opt32023.Meldingen.Melding;
import com.jipiekaye.opt32023.Meldingen.WindowsMelding;
import com.jipiekaye.opt32023.observerPattern.Observer;

public abstract class Taak implements Observer {
    private String titel;
    protected Melding melding;
    private int prioriteit;

    protected Klok klok;
    private int aantalMeldingenGegeven = 0;

    public Taak(String titel, Klok klok, int prioriteit) {
        this.titel = titel;
        this.prioriteit = prioriteit;
        this.klok = klok;
        klok.attachObserver(this);
        melding = new ConsoleMelding(titel);
    }

    public Taak(String titel, Klok klok, int prioriteit, boolean windowsMeldingAan) {
        this.titel = titel;
        this.prioriteit = prioriteit;
        this.klok = klok;
        klok.attachObserver(this);
        if (windowsMeldingAan)
            melding = new WindowsMelding(titel);
        else melding = new ConsoleMelding(titel);
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

    @Override
    public void update() {
        aantalMeldingenGegeven++;
        checkVoorMelding();
    }

    public void checkVoorMelding(){}

    public boolean isVandaag(){return true;}
}
