package ru.students.lab.vehicles;

import ru.students.lab.galaxy.CelestialBody;
import ru.students.lab.galaxy.Galaxy;
import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.timeTools.TimeManager;

public class Trajectory {

    private CelestialBody origin;
    private CelestialBody destiny;
    private double totalDistance;
    private int distanceTraveled;

    public Trajectory(CelestialBody origin, CelestialBody destiny) {
        this.origin = origin;
        this.destiny = destiny;
        this.distanceTraveled = 0;
        this.totalDistance = calcTotalDistance();
    }

    private double calcTotalDistance() {
        Coordinate oCoord = this.getOrigin().getLocation();
        Coordinate dCoord = this.getDestiny().getLocation();
        return (int) Math.sqrt(Math.pow(dCoord.getX() - oCoord.getX(), 2) +
                            Math.pow(dCoord.getY() - oCoord.getY(), 2));
    }

    public static int calcDisFromObserver(CelestialBody celBody) {
        return (int) Math.sqrt(Math.pow(celBody.getLocation().getX(), 2) +
                        Math.pow(celBody.getLocation().getY(), 2));
    }

    public void moveNearDestiny(int hours, Velocity velocity) {
        int newDistance = (hours * 3600) * velocity.getValue();
        this.distanceTraveled += newDistance;
        this.getDestiny().getLocation().dropX(newDistance);
        Galaxy.updatePosComponents(newDistance, this.getDestiny());
    }

    public CelestialBody getOrigin() {
        return origin;
    }

    public CelestialBody getDestiny() {
        return destiny;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    @Override
    public int hashCode() {
        int result = 42;
        result += this.getOrigin().hashCode() - this.getDestiny().hashCode();
        result >>= 4;
        result += this.getDistanceTraveled();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Trajectory))
            return false;
        if (obj == this)
            return true;
        Trajectory objTrajectory = (Trajectory) obj;
        return this.getTotalDistance() == objTrajectory.getTotalDistance() &&
                this.getOrigin().toString().equals(objTrajectory.getOrigin().toString()) &&
                this.getDestiny().toString().equals(objTrajectory.getDestiny().toString());
    }

    @Override
    public String toString() {
        return "Total trajectory's distance: " +
                this.getTotalDistance() + "Km " +
                "[Origin: " + this.getOrigin().getType().toString() +
                " -> Destiny: " + this.getDestiny().getType().toString() + "]";
    }
}
