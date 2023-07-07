package com.jipiekaye.opt32023;

import com.jipiekaye.opt32023.observerPattern.Observable;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Klok extends Observable implements Runnable {
    final private SimpleDateFormat timeFormat;
    final private SimpleDateFormat dayFormat;
    final private SimpleDateFormat dateFormat;
    private String tijd;
    private String dag;
    private String datum;

    public Klok() {
        timeFormat = new SimpleDateFormat("kk:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void run() {
        while(true) {
            tijd = timeFormat.format(Calendar.getInstance().getTime());

            dag = dayFormat.format(Calendar.getInstance().getTime());

            datum = dateFormat.format(Calendar.getInstance().getTime());

            //om de observers te laten weten dat de tijd is veranderd
            notifyObservers();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getTijd() {
        return tijd;
    }

    public String getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return tijd + "\n" + dag + "\n" + datum;
    }
}
