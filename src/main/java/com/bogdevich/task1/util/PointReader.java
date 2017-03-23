package com.bogdevich.task1.util;

import com.bogdevich.task1.entity.Point;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Adrienne on 21.03.17.
 */
public class PointReader {
    private final static String PATH = "src/main/resources/input.txt";
    private final static String STRING_PATTERN = "x=[0-9]+ +y=[0-9]+ +z=[0-9]";
    private final static int POINTS = 3;
    public static Point[] extractPointParams(String path){
        Pattern pattern = Pattern.compile(STRING_PATTERN);
        Matcher matcher;
        Point[] points = new Point[3];
        try{
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path), Charset.forName("utf-8")));
            for (String line :
                    lines) {
                matcher = pattern.matcher(line);
                if (matcher.matches()){
                    for (String param :
                            line.split(" +")) {

                    }
                }
            }

        }catch (Exception ex){

        }
        return null;
    }
}
