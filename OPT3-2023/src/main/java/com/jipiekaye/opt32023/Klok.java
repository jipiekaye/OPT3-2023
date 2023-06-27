package com.jipiekaye.opt32023;

import com.jipiekaye.opt32023.observerPattern.Subject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Klok extends Subject {
    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private String tijd;
    private String day;
    private String date;

    public Klok() {
        timeFormat = new SimpleDateFormat("kk:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        setDatetime();
    }

    public void setDatetime() {
        while(true) {
            tijd = timeFormat.format(Calendar.getInstance().getTime());

            day = dayFormat.format(Calendar.getInstance().getTime());

            date = dateFormat.format(Calendar.getInstance().getTime());
            System.out.println(toString());
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

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return tijd + "\n" + day + "\n" + date;
    }
}
