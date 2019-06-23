package com.company.observable;

import java.util.Observable;

public class ObservableChange extends Observable implements Notifier{
    public void change() {
        setChanged();
        notifyObservers();
    }
}
