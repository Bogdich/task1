package com.bogdevich.task1.service;

import com.bogdevich.task1.entity.Plane;
import com.bogdevich.task1.observer.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

/**
 * Created by Adrienne on 27.03.17.
 */
public class Corner implements Observer {

    private final static Logger LOGGER = LogManager.getLogger();

    private final static int[] XY = {0,0,1};
    private final static int[] YZ = {1,0,0};
    private final static int[] ZY = {0,1,0};

    private double cornerXY;
    private double cornerYZ;
    private double cornerZY;
    private Plane plane;

    public double getCornerXY() {
        return cornerXY;
    }

    public double getCornerYZ() {
        return cornerYZ;
    }

    public double getCornerZY() {
        return cornerZY;
    }

    public Plane getPlane() {
        return plane;
    }


    public Corner(Plane plane) {
        this.plane = plane;
        plane.add(this);
        calculateCorners();
    }

    private void calculateCorners(){
        LOGGER.debug("Calculating corners");
        int[] plane = getPlainParameters();
        cornerXY = calculateCorner(plane, XY);
        cornerYZ = calculateCorner(plane, YZ);
        cornerZY = calculateCorner(plane, ZY);
        LOGGER.info(this.toString());
    }
    private int[] getPlainParameters(){
        int[] vector1 = new int[]{
                plane.getB().getX()-plane.getA().getX(),
                plane.getB().getY()-plane.getA().getY(),
                plane.getB().getZ()-plane.getA().getZ()
        };
        int[] vector2 = new int[]{
                plane.getC().getX()-plane.getA().getX(),
                plane.getC().getY()-plane.getA().getY(),
                plane.getC().getZ()-plane.getA().getZ()
        };
        LOGGER.debug("Corner{" +
                "vector1=" + Arrays.toString(vector1) +
                ", vector2=" + Arrays.toString(vector2) +
                '}');
        int A = vector1[1]* vector2[2]- vector1[2]* vector2[1];
        int B = vector1[0]* vector2[2]- vector1[2]* vector2[0];
        int C = vector1[0]* vector2[1]- vector1[1]* vector2[0];
        LOGGER.debug("Plane parameters: "+A+" "+B+" "+C);
        return new int[]{A,B,C};
    }
    private double calculateCorner(int[] plane1, int[] plane2){
        double a = Math.abs(plane1[0]*plane2[0]+plane1[1]*plane2[1]+plane1[2]*plane2[2]);
        double b = Math.sqrt(Math.pow(plane1[0],2)+Math.pow(plane1[1],2)+Math.pow(plane1[2],2));
        double c = Math.sqrt(Math.pow(plane2[0],2)+Math.pow(plane2[1],2)+Math.pow(plane2[2],2));
        double cos = a/(b*c);
        return 180*(Math.acos(cos)/Math.PI);
    }

    @Override
    public void update(Plane plane) {
        LOGGER.info(this.plane.toString()+" was update to "+plane.toString());
        this.plane = plane;
        calculateCorners();
    }

    @Override
    public String toString() {
        return "Corner{" +
                "cornerXY=" + cornerXY + "deg" +
                ", cornerYZ=" + cornerYZ + "deg" +
                ", cornerZY=" + cornerZY + "deg" +
                '}';
    }
}
