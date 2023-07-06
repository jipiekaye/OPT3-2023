package com.jipiekaye.opt32023.Meldingen;

public class ConsoleMelding implements Melding {
    private String bericht;
    public ConsoleMelding(String titel) {
        this.bericht =
                "Taak: \n_____________\n"
                        + titel
                        + " \n Moet nu gedaan worden!";
    }

    public void doMelding() {
        System.out.println(bericht);
    }
}
