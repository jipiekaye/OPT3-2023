package com.jipiekaye.opt32023.TemplateMethodPattern;

import com.jipiekaye.opt32023.Klok;

public class ConstanteTaak extends Taak {

    private int timer;
    private int intervalTussenMelding;

    public ConstanteTaak(String titel, Klok klok, int aantalSecondenTotMelding, int prioriteit) {
        super(titel, klok, prioriteit);
        this.timer = aantalSecondenTotMelding;
        this.intervalTussenMelding = aantalSecondenTotMelding;
    }


    public void checkVoorMelding() {
        if (timer <= 0) {
            melding.doMelding();
            timer = intervalTussenMelding;
        }
        else timer --;
    }

    @Override
    public String toString() {
        return super.titel + "\n wordt elke: " +
                intervalTussenMelding/60 + " minuten en " +
                intervalTussenMelding%60 + " seconden gemeld." +
                "\n nog " + timer/60 + " minuten tot volgende melding.";
    }
}
