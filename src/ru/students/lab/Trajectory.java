package ru.students.lab;

public class Trajectory {

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
        return this.getOrigin().toString().hashCode() + this.getDestiny().toString().hashCode();
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
                "[Origin: " + this.getOrigin().toString() +
                " Destiny: " + this.getDestiny().toString() + "]";
    }
}
