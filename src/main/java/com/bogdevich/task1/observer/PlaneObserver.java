package com.bogdevich.task1.observer;

import com.bogdevich.task1.entity.Plane;

/**
 * Created by Adrienne on 28.03.17.
 */
public class PlaneObserver implements Observer{
    @Override
    public void update(Plane plane) {

    }
    /**
     * Add new observable.
     *
     * @param plane
     */
    public void addObservable(Plane plane) {
        /*
        int id = plane.getId();
         */

        /*
        double angleX = findAngleOverAxis(AXIS.X_AXIS, plane);
         */
        /*boolean isCrossAxisX = false;
        try {
            isCrossAxisX = isCrossAxis(AXIS.X_AXIS, plane);
        } catch (IllegalQuarterException e) {
            LOGGER.log(Level.ERROR, "Illegal quarter exception found!");
        }

        PlaneAttributes attr = new PlaneAttributes(angleX, isCrossAxisX);

        map.put(id, attr);


        LOGGER.log(Level.INFO, "New Observer has been added: Plane: " + plane.toString()
                + "; attributes: " + attr.toString());*/
    }

    /**
     * Remove the Observable from list.
     *
     * @param plane
     */
    public void removeObservable(Plane plane) {
        /*int planeId = plane.getId();

        map.remove(planeId);
        LOGGER.log(Level.INFO, "Plane(" + planeId + ") has been removed.");*/}
}
