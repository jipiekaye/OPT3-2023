package com.jipiekaye.opt32023.TemplateMethodPattern;

import com.jipiekaye.opt32023.Klok;
import com.jipiekaye.opt32023.Taak;

public class ConstanteTaak extends Taak {

    private int timer;
    private int intervalTussenMelding;

    public ConstanteTaak(String titel, Klok klok, int aantalSecondenTotMelding, int prioriteit) {
        super(titel, klok, prioriteit);
        this.timer = aantalSecondenTotMelding;
        this.intervalTussenMelding = aantalSecondenTotMelding;
    }

    @Override
    public void update() {
        if (timer < 1) {
            melding.doMelding();
            timer = intervalTussenMelding;
        }
        else timer --;
    }
}
