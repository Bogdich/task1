package com.bogdevich.task1.service;

import com.bogdevich.task1.entity.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adrienne on 27.03.17.
 */
public class Validator {

    private final static Logger LOGGER = LogManager.getLogger();

    private static final int POINTS_AMOUNT = 3;

    private Point[] points = new Point[POINTS_AMOUNT];
    private int[] vector1;
    private int[] vector2;
    private int A;
    private int B;
    private int C;

    public Validator(List<Point> points) {
        points.toArray(this.points);
        setPlainParameters();
        LOGGER.log(Level.DEBUG,"initialization: "+toString());
    }

    private void setPlainParameters(){
        this.vector1 = new int[]{points[1].getX()-points[0].getX(),points[1].getY()-points[0].getY(),points[1].getZ()-points[0].getZ()};
        this.vector2 = new int[]{points[2].getX()-points[0].getX(),points[2].getY()-points[0].getY(),points[2].getZ()-points[0].getZ()};
    }
    public boolean isPlane(){
        A = vector1[1]* vector2[2]- vector1[2]* vector2[1];
        B = vector1[0]* vector2[2]- vector1[2]* vector2[0];
        C = vector1[0]* vector2[1]- vector1[1]* vector2[0];
        return (A!=0 || B!=0 || C!=0);
    }
    public boolean isOrthogonal(){
        if(isPlane()){
            return
                    points[0].getX()==points[1].getX() && points[0].getX()!=0 || points[1].getX()==points[2].getX() && points[1].getX()!=0 ||
                    points[0].getY()==points[1].getY() && points[0].getY()!=0 || points[1].getY()==points[2].getY() && points[1].getY()!=0 ||
                    points[0].getZ()==points[1].getZ() && points[0].getZ()!=0 || points[1].getZ()==points[2].getZ() && points[1].getZ()!=0
                    ;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return
                "points=" + Arrays.toString(points);
    }
}
