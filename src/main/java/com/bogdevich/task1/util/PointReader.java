package com.bogdevich.task1.util;

import com.bogdevich.task1.entity.Point;
import com.bogdevich.task1.util.Exception.EmptyFileException;
import com.bogdevich.task1.util.Exception.InsufficientOfParametersException;
import com.bogdevich.task1.util.Exception.PointReaderException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Adrienne on 21.03.17.
 */
public class PointReader {
    private final static String PATH = "src/main/resources/input.txt";
    private final static String LINE_REGEX = "x=[0-9]+ +y=[0-9]+ +z=[0-9]+";
    private final static int NUMBER_OF_POINTS = 3;
    public static Point[] extractPointParams(String path, int numberOfPoints) throws PointReaderException{
        Pattern pattern = Pattern.compile(LINE_REGEX);
        Matcher matcher;
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<String> lines;// = new ArrayList<>();
        ListIterator<String> iterator;//= lines.listIterator();
        try{
            lines = (ArrayList<String>) Files.readAllLines(Paths.get(path), Charset.forName("utf-8"));
            iterator = lines.listIterator();
            if(lines.isEmpty()){
                throw new EmptyFileException("Error: empty file: "+path);
            }
            //throw new Exception();
            while(iterator.hasNext() && points.size()<numberOfPoints){
                String line = iterator.next();
                matcher = pattern.matcher(line);
                if (matcher.matches()){
                    String[] parsedNumbers = line.replaceAll("[xyz]=","").split(" +");
                    try{
                        points.add(new Point(
                                Integer.parseInt(parsedNumbers[0]),
                                Integer.parseInt(parsedNumbers[1]),
                                Integer.parseInt(parsedNumbers[2])
                        ));
                    }catch (NumberFormatException ex){
                        System.out.println("Line #"+iterator.nextIndex()+": out of int range: "+ex.getMessage());
                    }
                }else if(!matcher.matches()){
                    System.out.println("Incorrect line #" + (iterator.nextIndex()) + ": " + line);
                }
            }
            if (points.size()<numberOfPoints){
                throw new PointReaderException(
                        "No points were created: ",
                        new InsufficientOfParametersException("not enough of parameters "+path
                        ));
            }
        }catch (NoSuchFileException ex){
            System.out.println("File not found: "+ex.getFile());
            System.out.println("Default path: "+PATH);
            return extractPointParams(PATH, numberOfPoints);
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            extractPointParams(path, NUMBER_OF_POINTS);
        }catch (FileSystemException ex){
            System.out.println(ex.getReason());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }catch (EmptyFileException ex){
            System.out.println(ex.getMessage());
        }
        return points.toArray(new Point[numberOfPoints]);
    }
}
