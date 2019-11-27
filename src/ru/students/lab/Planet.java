package ru.students.lab;

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
        return this.getType().toString().hashCode() + this.getLocation().hashCode();
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
