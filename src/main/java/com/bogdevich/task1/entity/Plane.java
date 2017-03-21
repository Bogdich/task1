package com.bogdevich.task1.entity;

/**
 * Created by Adrienne on 21.03.17.
 */
public class Plane {
    private Point a;
    private Point b;
    private Point c;

    public Plane(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
