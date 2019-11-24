package ru.students.lab;

import java.util.ArrayList;

public abstract class AbsPlace {

    private String name;
    private ArrayList<Thing> things;

    public AbsPlace(String name) {
        this.name = name;
        this.things = new ArrayList<>();
    }

    public AbsPlace(String name, ArrayList<Thing> things) {
        this.name = name;
        this.things = things;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Thing> getThings() {
        return things;
    }

    public void addThing(Thing thing) {
        this.things.add(thing);
    }
}
