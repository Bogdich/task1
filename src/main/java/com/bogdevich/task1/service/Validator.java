package com.bogdevich.task1.service;

import com.bogdevich.task1.entity.Point;

/**
 * Created by Adrienne on 27.03.17.
 */
public class Validator {

    private static final int DIMENSION = 3;
    private static final int POINTS_AMOUNT = 3;

    private Point[] points = new Point[POINTS_AMOUNT];
    /*
    private int[][] A = new int[DIMENSION][POINTS_AMOUNT];
    private int[][] B = new int[DIMENSION][POINTS_AMOUNT];
    private int[][] C = new int[DIMENSION][POINTS_AMOUNT];
    private int[][] D = new int[DIMENSION][POINTS_AMOUNT];
    */
    private int[] a;// = new int[DIMENSION];
    private int[] b;// = new int[DIMENSION];

    public Validator(Point[] points) {
        this.points = points;
        setPlainParameters();
    }

    private void setPlainParameters(){
        /*for (int i = 0; i<POINTS_AMOUNT; i++){
            A[i][0] = 1;
            A[i][1] = points[i].getY();
            A[i][2] = points[i].getZ();

            B[i][0] = points[i].getX();
            B[i][1] = 1;
            B[i][2] = points[i].getZ();

            C[i][0] = points[i].getX();
            C[i][1] = points[i].getY();
            C[i][2] = 1;
        }*/
        this.a = new int[]{points[1].getX()-points[0].getX(),points[1].getY()-points[0].getY(),points[1].getZ()-points[0].getZ()};
        this.b = new int[]{points[2].getX()-points[0].getX(),points[2].getY()-points[0].getY(),points[2].getZ()-points[0].getZ()};
    }
    public boolean isPlane(){
        /*
                int a = A[1][0]*(A[2][1]-A[2][2])+A[1][1]*(A[2][2]-A[2][0])+A[1][2]*(A[2][0]-A[2][1]);
        int b = B[2][0]*(B[1][1]-B[1][2])+B[2][1]*(B[1][2]-B[1][0])+B[2][2]*(B[1][0]-B[1][1]);
        int c = C[0][0]*(C[1][1]-C[1][2])+C[0][1]*(C[1][2]-C[1][0])+C[0][2]*(C[1][0]-C[1][1]);
        return (a!=0 || b!=0 || c!=0);
         */
        int x = a[1]*b[2]-a[2]*b[1];
        int y = a[0]*b[2]-a[2]*b[0];
        int z = a[0]*b[1]-a[1]*b[0];
        return (x!=0 || y!=0 || z!=0);
    }
    public boolean isOrthogonal(){
        if(isPlane()){
            return
                    points[0].getX()==points[1].getX() && points[1].getX()==points[2].getX() ||
                    points[0].getY()==points[1].getY() && points[1].getY()==points[2].getY() ||
                    points[0].getZ()==points[1].getZ() && points[1].getZ()==points[2].getZ()
                    ;
        }
        else{
            return false;
        }
    }
}
