package ru.students.lab;

public class Trajectory implements InterStandardFunctions {

    private Planets origin;
    private Planets destiny;

    public Trajectory() {

    }

    public Trajectory(Planets origin, Planets destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public double calcDistance() {
        return (int) (this.getDestiny().getDistanceFromSun() - this.getOrigin().getDistanceFromSun());
    }

    public Planets getOrigin() {
        return origin;
    }

    public Planets getDestiny() {
        return destiny;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Total Trajectory: " + this.calcDistance() + "Km";
    }
}
