package com.jipiekaye.opt32023.TemplateMethodPattern;

import com.jipiekaye.opt32023.Klok;
import com.jipiekaye.opt32023.Meldingen.ConsoleMelding;
import com.jipiekaye.opt32023.Meldingen.Melding;
import com.jipiekaye.opt32023.Meldingen.WindowsMelding;
import com.jipiekaye.opt32023.observerPattern.Observer;

public abstract class Taak implements Observer {
    protected String titel;
    protected int prioriteit;

    protected Klok klok;
    private int aantalMeldingenGegeven = 0;

    private boolean meldingSchermAan = false;

    public Taak(String titel, Klok klok, int prioriteit) {
        this.titel = titel;
        this.prioriteit = prioriteit;
        this.klok = klok;
        klok.attachObserver(this);
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

    public void checkVoorMelding() {
    }

    public boolean isVandaag() {
        return true;
    }

    public void setMeldingSchermAan(boolean meldingSchermAan) {
        this.meldingSchermAan = meldingSchermAan;
    }

    public boolean isMeldingSchermAan() {
        return meldingSchermAan;
    }

    protected void doMelding() {
        if (isMeldingSchermAan()) {
            ConsoleMelding melding = new ConsoleMelding(titel);
            melding.doMelding();
        } else {
            WindowsMelding melding = new WindowsMelding(titel);
            melding.doMelding();
        }
    }
}
