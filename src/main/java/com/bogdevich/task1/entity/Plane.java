package com.bogdevich.task1.entity;

import com.bogdevich.task1.observer.Observer;
import com.bogdevich.task1.observer.PlaneObserver;
import com.bogdevich.task1.observer.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Adrienne on 21.03.17.
 */
public class Plane implements Subject<PlaneObserver>{
    private final static Logger LOGGER = LogManager.getLogger();

    private Point a;
    private Point b;
    private Point c;

    private PlaneObserver observer;

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
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public void add(PlaneObserver observer) {
        this.observer = observer;
        observer.addObservable(this);
    }

    @Override
    public void remove(PlaneObserver observer) {
        observer.removeObservable(this);
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
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
