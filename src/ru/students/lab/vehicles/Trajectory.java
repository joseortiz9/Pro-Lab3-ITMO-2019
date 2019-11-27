package ru.students.lab.vehicles;

import ru.students.lab.planets.Planet;
import ru.students.lab.locationTools.Coordinate;

public class Trajectory {

    private Planet origin;
    private Planet destiny;
    private int timElapsed;
    private int distanceTraveled;

    public Trajectory() {

    }

    public Trajectory(Planet origin, Planet destiny) {
        this.origin = origin;
        this.destiny = destiny;
        this.distanceTraveled = 0;
        this.timElapsed = 0;
    }

    public double calcDistance() {
        Coordinate oCoord = this.getOrigin().getLocation();
        Coordinate dCoord = this.getDestiny().getLocation();
        return (int) Math.sqrt(Math.pow(dCoord.getX() - oCoord.getX(), 2) +
                Math.pow(dCoord.getY() - oCoord.getY(), 2));
    }

    public void getNearDestiny(double hours, Velocity velocity) {
        this.timElapsed += hours * 3600;
        this.distanceTraveled += this.getTimElapsed() * velocity.getValue();
        this.getDestiny().getLocation().dropX(getDistanceTraveled());
    }

    public Planet getOrigin() {
        return origin;
    }

    public Planet getDestiny() {
        return destiny;
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public int getTimElapsed() {
        return this.timElapsed;
    }

    @Override
    public int hashCode() {
        return this.getOrigin().hashCode() + this.getDestiny().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Trajectory))
            return false;
        if (obj == this)
            return true;
        Trajectory objTrajectory = (Trajectory) obj;
        return this.calcDistance() == objTrajectory.calcDistance() &&
                this.getOrigin().toString().equals(objTrajectory.getOrigin().toString()) &&
                this.getDestiny().toString().equals(objTrajectory.getDestiny().toString());
    }

    @Override
    public String toString() {
        return "Total trajectory's distance: " +
                this.calcDistance() + "Km " +
                "[Origin: " + this.getOrigin().getType().toString() +
                " -> Destiny: " + this.getDestiny().getType().toString() + "]";
    }
}
