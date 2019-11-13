package ru.students.lab;

import java.util.ArrayList;

public class Place extends AbsPlace {

    public Place(String name) {
        super(name);
    }

    public Place(String name, ArrayList<Thing> things) {
        super(name, things);
    }

}
