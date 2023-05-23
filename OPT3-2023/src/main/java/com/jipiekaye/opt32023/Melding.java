package com.jipiekaye.opt32023;

public class Melding {
    private String bericht;
    public Melding(String titel) {
        this.bericht = titel + " moet nu gedaan worden!";
    }
    public void popup(){
        System.out.println(bericht);
    }
}
