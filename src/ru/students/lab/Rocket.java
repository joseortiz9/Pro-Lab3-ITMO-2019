package ru.students.lab;

import java.util.ArrayList;

public class Rocket extends AbsVehicle implements InterLocationUtilities {

    private ArrayList<Place> rooms;
    private Trajectory trajectory;
    private MovingState movingState;

    public Rocket(TypeVehicles typeVehicles) {
        super(typeVehicles);
        this.rooms = new ArrayList<>();
        this.trajectory = null;
        this.movingState = MovingState.STAGNATION;
    }

    public Rocket(TypeVehicles typeVehicles, int velocity, Trajectory trajectory) {
        super(typeVehicles, velocity);
        this.rooms = new ArrayList<>();
        this.trajectory = null;
        this.movingState = this.calcStateVelocity();
    }

    public Rocket(TypeVehicles typeVehicles, int velocity, Trajectory trajectory, ArrayList<Place> rooms) {
        super(typeVehicles, velocity);
        this.trajectory = trajectory;
        this.rooms = rooms;
        this.movingState = this.calcStateVelocity();
    }

    public void addRoom(Place room) {
        rooms.add(room);
    }

    //If the velocity is enought to arrive in less than an hour
    public boolean isVelocityBig() {
        return this.getVelocity().getValue() > getTrajectory().calcDistance() / 60;
    }

    public MovingState calcStateVelocity() {
        if (this.getVelocity().getValue() == 0)
            return MovingState.STAGNATION;
        return (isVelocityBig()) ? MovingState.FAST : MovingState.SLOW ;
    }

    public boolean overMiddleOfPath() {
        return this.getDistanceTraveled() > this.getTrajectory().calcDistance() / 2;
    }

    public void starts() {
        System.out.println(this.toString() + " rushes with a velocity of " + this.getVelocity().toString());
    }

    @Override
    public void printLocation() {
        if (overMiddleOfPath())
            System.out.println(this.toString() + " is getting near to Destiny!");
        else
            System.out.println(this.toString() + " hasn't advance even a finger!");
    }

    public void printMovement() {
        System.out.println(this.toString() + " went forward " + getDistanceTraveled() + "Km");
    }

    public void printTrajectory() {
        System.out.println(this.getTrajectory().toString());
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public MovingState getMovingState() {
        return movingState;
    }

    @Override
    public int hashCode() {
        return this.getTypeVehicles().toString().hashCode() +
                this.getVelocity().getValue() +
                this.getDistanceTraveled();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rocket))
            return false;
        if (obj == this)
            return true;
        Rocket objRocket = (Rocket) obj;
        return this.getVelocity().getValue() == objRocket.getVelocity().getValue() &&
                this.getDistanceTraveled() == objRocket.getDistanceTraveled() &&
                this.getTypeVehicles().toString().equals(objRocket.getTypeVehicles().toString());
    }

    @Override
    public String toString() {
        return super.getTypeVehicles().toString();
    }
}


