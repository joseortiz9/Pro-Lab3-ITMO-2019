package ru.students.lab;

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
        if (obj == null)
            return false;
        if (!(obj instanceof Place))
            return false;
        if (obj == this)
            return true;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
