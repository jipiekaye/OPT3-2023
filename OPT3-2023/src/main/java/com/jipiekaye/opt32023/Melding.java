package com.jipiekaye.opt32023;

import com.jipiekaye.opt32023.observerPattern.Observer;

public class Melding implements Observer {
    private String bericht;
    private String deadlineDatum;
    private String deadlineTijd;
    private Klok klok;


    public Melding(String titel, Klok klok, String deadlineDatum, String deadlineTijd) {
        this.bericht = titel + " moet nu gedaan worden!";
        this.klok = klok;
        klok.attachObserver(this);
        this.deadlineDatum = deadlineDatum;
        this.deadlineTijd = deadlineTijd;
    }

    public Melding(String titel) {
        this.bericht = titel + " moet nu gedaan worden!";
    }
    public boolean popupsAan(boolean isIngelogd, boolean wilWerken, boolean wilPopups){
        return isIngelogd && wilWerken && wilPopups;
    }

    @Override
    public void update() {
        if (klok.getDatum().equals(deadlineDatum))
            if (klok.getTijd().equals(deadlineTijd))
                doMelding();
    }

    private void doMelding() {
        System.out.println(bericht);
    }
}