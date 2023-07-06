package com.jipiekaye.opt32023.TemplateMethodPattern;

import com.jipiekaye.opt32023.Klok;

public class EnkeleTaak extends Taak {

    private String deadlineDatum;
    private String deadlineTijd;
    public EnkeleTaak(String titel, Klok klok, String deadlineDatum, String deadlineTijd, int prioriteit) {
        super(titel, klok, prioriteit);
        this.deadlineDatum = deadlineDatum;
        this.deadlineTijd  = deadlineTijd;
    }


    public void checkVoorMelding() {
        if (klok.getDatum().equals(deadlineDatum))
            if (klok.getTijd().equals(deadlineTijd))
                melding.doMelding();
    }

    public boolean isVandaag(){
        return deadlineDatum.equals(klok.getDatum());
    }

    @Override
    public String toString() {
        return super.titel + "\n deadline: " + deadlineDatum + " " + deadlineTijd;
    }
}
