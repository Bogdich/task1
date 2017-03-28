package com.bogdevich.task1.util;

import com.bogdevich.task1.entity.Point;
import com.bogdevich.task1.util.Exception.EmptyFileException;
import com.bogdevich.task1.util.Exception.InsufficientOfParametersException;
import com.bogdevich.task1.util.Exception.PointReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Adrienne on 21.03.17.
 */
public class PointReader {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String PATH = "src/main/resources/input.txt";
    private final static String LINE_REGEX = "x=[0-9]+ +y=[0-9]+ +z=[0-9]+";
    private final static int NUMBER_OF_POINTS = 3;
    public static List<Point> extractPointParams(String path, int numberOfPoints) throws PointReaderException{
        Pattern pattern = Pattern.compile(LINE_REGEX);
        Matcher matcher;
        List<Point> points = new ArrayList<>();
        List<String> lines;// = new ArrayList<>();
        ListIterator<String> iterator;//= lines.listIterator();
        try{
            lines = Files.readAllLines(Paths.get(path), Charset.forName("utf-8"));
            iterator = lines.listIterator();
            if(lines.isEmpty()){
                throw new EmptyFileException("empty file: "+path);
            }
            if (numberOfPoints<1){
                throw new ArrayIndexOutOfBoundsException("trying to get null or negative value of point amount");
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
                        LOGGER.log(Level.ERROR,"Line #"+iterator.nextIndex()+": out of int range: "+ex.getMessage());
                    }
                }else if(!matcher.matches()){
                    LOGGER.log(Level.ERROR,"Incorrect line #" + (iterator.nextIndex()) + ": " + line);
                }
            }
            if (points.size()<numberOfPoints){throw new InsufficientOfParametersException("not enough of parameters in "+path);
                /*
                throw new PointReaderException(
                        "No points were created: ",
                        new InsufficientOfParametersException("not enough of parameters "+path
                        ));*/
            }
        }catch (NoSuchFileException ex){
            LOGGER.log(Level.ERROR,"File not found: "+ex.getFile());
            LOGGER.log(Level.INFO,"Default path: "+PATH);
            return extractPointParams(PATH, numberOfPoints);
        }catch (ArrayIndexOutOfBoundsException ex){
            LOGGER.log(Level.FATAL,ex.getMessage());
            extractPointParams(path, NUMBER_OF_POINTS);
        }catch (FileSystemException ex){
            LOGGER.log(Level.FATAL,ex.getMessage());
        }catch (IOException ex){
            throw new PointReaderException("File parsing failed "+path,ex);
        }catch (EmptyFileException ex){
            LOGGER.log(Level.FATAL,ex.getMessage());
        }catch (InsufficientOfParametersException ex){
            LOGGER.fatal(ex.getMessage());
        }
        return points;
    }
}
