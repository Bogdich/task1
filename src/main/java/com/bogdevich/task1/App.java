package com.bogdevich.task1;

import com.bogdevich.task1.entity.Point;
import com.bogdevich.task1.service.Validator;
import com.bogdevich.task1.util.Exception.PointReaderException;
import com.bogdevich.task1.util.PointReader;
import sun.security.pkcs.ParsingException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static String STRING_PATTERN = "x=[0-9]+ +y=[0-9]+ +z=[0-9]+";

    public static void main( String[] args )
    {
        //Point  point = PointReader.extractPointParams("src/main/resources/input.txt",1);
        //Point point = new Point();
        try{
            Validator validator = new Validator(PointReader.extractPointParams("src/main/resources/input.txt",3));
            System.out.println(validator.isOrthogonal());
        }catch(PointReaderException ex){
            System.out.println(ex.getMessage()+ex.getCause().getMessage());
        }

    }
}
