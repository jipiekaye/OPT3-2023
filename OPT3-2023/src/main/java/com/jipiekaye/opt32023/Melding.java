package com.jipiekaye.opt32023;

import com.jipiekaye.opt32023.observerPattern.Observer;

public class Melding implements Observer {
    private String bericht;
    public Melding(String titel) {
        this.bericht = titel + " moet nu gedaan worden!";
    }
    public boolean popupsAan(boolean isIngelogd, boolean wilWerken, boolean wilPopups){
        return isIngelogd && wilWerken && wilPopups;
    }

    @Override
    public void update() {

    }
}