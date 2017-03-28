package com.bogdevich.task1.service;

import com.bogdevich.task1.entity.Plane;
import com.bogdevich.task1.entity.Point;
import com.bogdevich.task1.util.Exception.PointReaderException;
import com.bogdevich.task1.util.PointReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Adrienne on 28.03.17.
 */
public class PlaneCreator {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int NUMBER_OF_PARAMETERS = 3;
    public static Plane create(String path){
        try{
            List<Point> points = PointReader.extractPointParams(path, NUMBER_OF_PARAMETERS);
            if (points.size()==3){
                Validator validator = new Validator(points);
                if (validator.isPlane()){
                    return new Plane(points.get(0),points.get(1),points.get(2));
                }
            }else{
                LOGGER.fatal("Can not create plain with "+points.size()+" parameters");
                throw new RuntimeException();
            }

        }catch(PointReaderException ex){
            LOGGER.log(Level.ERROR,"Can not extract points from file "+path);
            throw new RuntimeException();
        }
        return null;
    }
}
