package ru.students.lab;

import java.util.ArrayList;
import java.util.Arrays;

public class Human implements InterHuman, InterStandardFunctions {

    private String name;
    private ArrayList<Organs> organs;
    private Place actualPlace;
    private boolean awake;

    public Human(String name, Place place) {
        this.name = name;
        this.actualPlace = place;
        this.organs = new ArrayList<>(Arrays.asList(Organs.values()));
        this.awake = true;
    }

    public Human(String name, Place place, boolean awake) {
        this.name = name;
        this.actualPlace = place;
        this.organs = new ArrayList<>(Arrays.asList(Organs.values()));
        this.organs.add(Organs.Eyes);
        this.organs.add(Organs.Stomach);
        this.awake = awake;
    }

    @Override
    public void knows(boolean know) {
        String possible = (know) ? " " : " doesn't";
        System.out.print(this.getName() + possible + " know that ");
    }

    @Override
    public void sees(Object obj) {
        System.out.println(getName() + " sees " + obj.toString());
    }

    @Override
    public void eats(Thing thing) {
        if (thing.isType("food"))
            System.out.println(getName() + " eats " + thing.toString());
    }

    @Override
    public void usesOrgan(Organs organ) {
        switch(organ) {
            case Eyes:
                System.out.println(getName() + " gets interested");
            break;
            case Stomach:
                System.out.println(getName() + " feels hunger");
            break;
            default:
                System.out.println("Feeling Things");
        }
    }

    public void wakeUp() {
        this.awake = true;
        System.out.println(getName() + " wakes up");
    }

    public void printLocation() {
        System.out.println(getName() + " is in " + getActualPlace());
    }

    @Override
    public void moves(Place nextPlace) {
        this.actualPlace = nextPlace;
        System.out.println(getName() + " moves to " + nextPlace.getName());
    }

    public boolean isAwake() {
        return this.awake;
    }

    public String getName() {
        return this.name;
    }

    public String getActualPlace() {
        return actualPlace.getName();
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
        return getName();
    }
}
