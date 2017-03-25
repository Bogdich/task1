package com.bogdevich.task1.util;

import com.bogdevich.task1.entity.Point;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Adrienne on 21.03.17.
 */
public class PointReader {
    private final static String PATH = "src/main/resources/input.txt";
    private final static String LINE_REGEX = "x=[0-9]+ +y=[0-9]+ +z=[0-9]";
    private final static int POINTS = 3;
    public static Point[] extractPointParams(String path){
        Pattern pattern = Pattern.compile(LINE_REGEX);
        Matcher matcher;
        Point[] point = new Point[3];
        ArrayList<Point> points = new ArrayList<>();
        try{
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(path), Charset.forName("utf-8")));
            for (String line :
                    lines) {
                matcher = pattern.matcher(line);
                if (matcher.matches()){
                    String[] parsedNumbers = line.replaceAll("[xyz]=","").split(" +");
                    points.add(new Point(
                            Integer.parseInt(parsedNumbers[0]),
                            Integer.parseInt(parsedNumbers[1]),
                            Integer.parseInt(parsedNumbers[2])
                    ));
                }
            }

        }catch (Exception ex){

        }
        return null;
    }
}
