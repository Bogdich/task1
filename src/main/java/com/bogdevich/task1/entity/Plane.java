package com.bogdevich.task1.entity;

import com.bogdevich.task1.observer.Observer;
import com.bogdevich.task1.observer.PlaneObserver;
import com.bogdevich.task1.observer.Subject;
import com.bogdevich.task1.service.Corner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Adrienne on 21.03.17.
 */
public class Plane implements Subject<Observer>{
    private final static Logger LOGGER = LogManager.getLogger();

    private Point a;
    private Point b;
    private Point c;

    private ArrayList<Observer> observers = new ArrayList<>();

    public Plane(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        LOGGER.info("New "+this.toString());
    }

    public Plane() {
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        notifyObservers();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        notifyObservers();
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        notifyObservers();
    }

    @Override
    public void add(Observer observer) {
        this.observers.add(observer);
        observer.update(this);
    }

    @Override
    public void remove(Observer observer) {
        ListIterator<Observer> iterator = observers.listIterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(observer)){
                iterator.remove();
                LOGGER.info("Observer "+observer.toString()+"was removed from plane observers");
            }else{
                LOGGER.info("Observer "+observer.toString()+"wasn't removed from plane observers: there is no such one");
            }
        }
    }

    @Override
    public void notifyObservers() {
        LOGGER.info("Some plane was updated");
        ListIterator<Observer> iterator = observers.listIterator();
        while(iterator.hasNext()){
            iterator.next().update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;

        Plane plane = (Plane) o;

        if (getA() != null ? !getA().equals(plane.getA()) : plane.getA() != null) return false;
        if (getB() != null ? !getB().equals(plane.getB()) : plane.getB() != null) return false;
        return getC() != null ? getC().equals(plane.getC()) : plane.getC() == null;
    }

    @Override
    public int hashCode() {
        int result = getA() != null ? getA().hashCode() : 0;
        result = 31 * result + (getB() != null ? getB().hashCode() : 0);
        result = 31 * result + (getC() != null ? getC().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "a=" + "(" + a + ")" +
                ", b=" + "(" + b + ")" +
                ", c=" + "(" + c + ")" +
                '}';
    }
}
