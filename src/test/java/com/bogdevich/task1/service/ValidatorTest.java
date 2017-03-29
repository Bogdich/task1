package com.bogdevich.task1.service;

import com.bogdevich.task1.entity.Point;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by Adrienne on 28.03.17.
 */
@RunWith(value = Parameterized.class)
public class ValidatorTest {
    Validator validator;
    ArrayList<Boolean> condition;
    ArrayList<Point> points;

    public ValidatorTest(ArrayList<Boolean> condition, ArrayList<Point> points){
        this.condition = condition;
        this.points = points;
        validator = new Validator(points);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> set_of_parameters()
    {
        return Arrays.asList( new Object[][] {
                { new ArrayList<Boolean>(Arrays.asList(true,false)),new ArrayList<Point>(Arrays.asList(new Point(1,0,0), new Point(0,1,0), new Point(0,0,1)))} ,
                { new ArrayList<Boolean>(Arrays.asList(true,true)),new ArrayList<Point>(Arrays.asList(new Point(1,0,0), new Point(0,1,0), new Point(0,1,1)))} ,
                { new ArrayList<Boolean>(Arrays.asList(false,false)),new ArrayList<Point>(Arrays.asList(new Point(0,0,0), new Point(1,1,1), new Point(2,2,2)))} ,
                { new ArrayList<Boolean>(Arrays.asList(false,false)),new ArrayList<Point>(Arrays.asList(new Point(2,2,2), new Point(0,0,0), new Point(2,2,2)))}
        } );
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isPlane() throws Exception {
        assertThat(validator.isPlane(),equalTo(condition.get(0)));
    }

    @Test
    public void isOrthogonal() throws Exception {
        assertThat(validator.isOrthogonal(),equalTo(condition.get(1)));
    }

}