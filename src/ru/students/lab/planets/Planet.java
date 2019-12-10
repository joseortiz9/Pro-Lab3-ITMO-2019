package ru.students.lab.planets;

import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.locationTools.InterLocationUtilities;

public class Planet implements InterLocationUtilities {
    private TypePlanets type;
    private Coordinate location;

    public Planet(TypePlanets type, Coordinate location) {
        this.type = type;
        this.location = location;
    }

    public TypePlanets getType() {
        return type;
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
        if (!(obj instanceof Planet))
            return false;
        if (obj == this)
            return true;
        Planet objPlanet = (Planet) obj;
        return this.getLocation().equals(objPlanet.getLocation()) &&
                this.getType().equals(objPlanet.getType());
    }

    @Override
    public String toString() {
        return this.getType().toString() + this.getLocation().toString();
    }
}
