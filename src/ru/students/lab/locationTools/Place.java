package ru.students.lab.locationTools;

import ru.students.lab.things.Thing;

import java.util.ArrayList;

public class Place extends AbsPlace {

    public Place(String name) {
        super(name);
    }

    public Place(String name, ArrayList<Thing> things) {
        super(name, things);
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getThings().size();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Place))
            return false;
        if (obj == this)
            return true;
        Place objPlace = (Place) obj;
        return this.getThings().size() == objPlace.getThings().size() &&
                this.getName().equals(objPlace.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
