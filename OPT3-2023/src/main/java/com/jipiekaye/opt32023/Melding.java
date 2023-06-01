package com.jipiekaye.opt32023;

public class Melding {
    private String bericht;
    public Melding(String titel) {
        this.bericht = titel + " moet nu gedaan worden!";
    }
    public boolean popupsAan(boolean isIngelogd, boolean wilWerken, boolean wilPopups){
        return isIngelogd && wilWerken && wilPopups;
    }
}