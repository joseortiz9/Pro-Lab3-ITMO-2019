package ru.students.lab.locationTools;

import ru.students.lab.things.Thing;

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

    public boolean hasThing(Thing thing) {
        return this.getThings().contains(thing);
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
