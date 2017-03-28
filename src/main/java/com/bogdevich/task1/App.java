package com.bogdevich.task1;

import com.bogdevich.task1.entity.Plane;
import com.bogdevich.task1.entity.Point;
import com.bogdevich.task1.service.Corner;
import com.bogdevich.task1.service.PlaneCreator;
import com.bogdevich.task1.service.Validator;
import com.bogdevich.task1.util.Exception.InsufficientOfParametersException;
import com.bogdevich.task1.util.Exception.PointReaderException;
import com.bogdevich.task1.util.PointReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.security.pkcs.ParsingException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static Logger LOGGER = LogManager.getLogger();

    public static void main( String[] args )
    {
        Plane plane = PlaneCreator.create("src/resources/input.txt");
        Corner corner = new Corner(plane);
        plane.setC(new Point(0,0,2));

    }
}
