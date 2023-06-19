package com.jipiekaye.opt32023;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Obeserver> observers = new ArrayList<>();
    public void attachObserver(Obeserver obs) {}
    public void detachObserver(Obeserver obs) {}
    public void notifyObservers() {}
}
