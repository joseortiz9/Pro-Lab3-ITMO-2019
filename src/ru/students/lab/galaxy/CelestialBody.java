package ru.students.lab.galaxy;

import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.locationTools.InterLocationUtilities;

public class CelestialBody implements InterLocationUtilities {
    private String name;
    private TypeCelestialBodies type;
    private Coordinate location;

    public CelestialBody(String name, TypeCelestialBodies type, Coordinate location) {
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public TypeCelestialBodies getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public Coordinate getLocation() {
        return this.location;
    }

    @Override
    public int hashCode() {
        int result = 28;
        result += (this.getType().hashCode()/50) >> 2;
        result += this.getLocation().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CelestialBody))
            return false;
        if (obj == this)
            return true;
        CelestialBody objCelBody = (CelestialBody) obj;
        return this.getLocation().equals(objCelBody.getLocation()) &&
                this.getType().equals(objCelBody.getType());
    }

    @Override
    public String toString() {
        return this.getName() + this.getLocation().toString();
    }
}