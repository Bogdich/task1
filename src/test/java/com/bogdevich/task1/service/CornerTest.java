package com.bogdevich.task1.service;

import com.bogdevich.task1.entity.Plane;
import com.bogdevich.task1.entity.Point;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.Matchers.*;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Adrienne on 28.03.17.
 */
@RunWith(value = Parameterized.class)
public class CornerTest {
    private static Plane plane;
    private static Corner corner;
    private ArrayList<Point> points;
    private ArrayList<Integer> expected;

    @Parameterized.Parameters
    public static Collection<Object[]> set_of_parameters()
    {
        return Arrays.asList( new Object[][] {
                { new ArrayList<Integer>(Arrays.asList(54,54,54)),new ArrayList<Point>(Arrays.asList(new Point(1,0,0), new Point(0,1,0), new Point(0,0,1)))} ,
                { new ArrayList<Integer>(Arrays.asList(90,45,45)),new ArrayList<Point>(Arrays.asList(new Point(1,0,0), new Point(0,1,0), new Point(0,1,1)))} ,
                { new ArrayList<Integer>(Arrays.asList(0,90,90)),new ArrayList<Point>(Arrays.asList(new Point(1,0,0), new Point(0,1,0), new Point(0,0,0)))}
        } );
    }

    public CornerTest(ArrayList<Integer> expected,ArrayList<Point> points)
    {
        this.expected = expected;
        this.points = points;
        this.plane = new Plane(points.get(0),points.get(1),points.get(2));
        corner = new Corner(plane);
    }

    @Test
    public void getCornerXY() throws Exception {
        assertThat(corner.getCornerXY(),is(closeTo(expected.get(0),1)));
    }

    @Test
    public void getCornerYZ() throws Exception {
        assertThat(corner.getCornerXY(),is(closeTo(expected.get(0),1)));
    }

    @Test
    public void getCornerZY() throws Exception {
        assertThat(corner.getCornerXY(),is(closeTo(expected.get(0),1)));
    }
}