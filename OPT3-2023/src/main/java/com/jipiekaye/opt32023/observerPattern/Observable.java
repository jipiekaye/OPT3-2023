package com.jipiekaye.opt32023.observerPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();
    public void attachObserver(Observer obs) {
        observers.add(obs);
    }
    public void detachObserver(Observer obs) {
        observers.remove(obs);
    }
    public void notifyObservers() {
        for (var observer : observers) {
            observer.update();
        }
    }
}
