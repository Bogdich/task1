package com.bogdevich.task1.service;

import com.bogdevich.task1.entity.Plane;
import com.bogdevich.task1.entity.Point;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrienne on 28.03.17.
 */
public class CornerTest {
    private static Plane plane;
    private static Corner corner;
    @BeforeClass
    public static void initialization(){
        plane = new Plane(new Point(0,0,3),new Point(0,3,0),new Point(3,0,0));
    }
    @Test
    public void getCornerXY() throws Exception {

    }

    @Test
    public void getCornerYZ() throws Exception {

    }

    @Test
    public void getCornerZY() throws Exception {

    }

}