package ru.students.lab;

import java.util.ArrayList;

public abstract class AbsPlace {
    private String name;
    private Coordinate coordinates;
    //private ArrayList
    private AbsPlace(String name, Coordinate coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private String getName() {
        return name;
    }

    public double[] getCoordinates() {
        return coordinates.getCoordinate();
    }
}
