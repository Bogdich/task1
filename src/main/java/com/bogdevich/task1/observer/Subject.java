package com.bogdevich.task1.observer;

/**
 * Created by Adrienne on 28.03.17.
 */
public interface Subject<T> {
    void add(T observer);
    void remove(T observer);
    void notifyObservers();
}
