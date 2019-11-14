package ru.students.lab;

import java.util.ArrayList;

public class Place extends AbsPlace implements InterStandardFunctions {

    public Place(String name) {
        super(name);
    }

    public Place(String name, ArrayList<Thing> things) {
        super(name, things);
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
