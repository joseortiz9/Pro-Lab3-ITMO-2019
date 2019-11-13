package ru.students.lab;

import java.util.ArrayList;

public class Human implements InterHuman, InterStandardFunctions {

    private String name;
    private ArrayList<Organs> organs;
    private Place actualPlace;

    public Human(String name, Place place) {
        this.name = name;
        this.actualPlace = place;
    }

    @Override
    public void feel(Organs organ) {
        switch(organ) {
            case Eyes:

                break;
            case Stomach:
                break;
            default:
                System.
        }

    }

    public Place getActualPlace() {
        return actualPlace;
    }

    @Override
    public void move(Place nextPlace) {
        this.actualPlace = nextPlace;
        System.out.println(name + " moves to " + nextPlace.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
