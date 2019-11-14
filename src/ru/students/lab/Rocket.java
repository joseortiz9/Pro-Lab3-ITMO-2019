package ru.students.lab;

import java.util.ArrayList;

public class Rocket extends AbsVehicle implements InterStandardFunctions {

    private ArrayList<Place> rooms;
    private Trajectory trajectory;

    public Rocket(TypeVehicle typeVehicle) {
        super(typeVehicle);
        this.rooms = new ArrayList<>();
        this.trajectory = null;
    }

    public Rocket(TypeVehicle typeVehicle, int velocity) {
        super(typeVehicle, velocity);
        this.rooms = new ArrayList<>();
        this.trajectory = null;
    }

    public Rocket(TypeVehicle typeVehicle, int velocity, Trajectory trajectory) {
        super(typeVehicle, velocity);
        this.trajectory = trajectory;
        this.rooms = new ArrayList<>();
    }

    public Rocket(TypeVehicle typeVehicle, int velocity, Trajectory trajectory, ArrayList<Place> rooms) {
        super(typeVehicle, velocity);
        this.trajectory = trajectory;
        this.rooms = rooms;
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
        return super.getTypeVehicle().toString();
    }

    public void addRoom(Place room) {
        rooms.add(room);
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public boolean overMiddleOfPath() {
        return this.getDistanceTraveled() > this.getTrajectory().calcDistance() / 2;
    }

    public void starts() {
        System.out.println(this.toString() + " rushes with a velocity of " + this.getVelocityStr());
    }

    public void isNearDestiny() {
        if (this.overMiddleOfPath())
            System.out.println(this.toString() + " is Near!");
        else
            System.out.println(this.toString() + " is not even a finger near to Destiny!");
    }

    public void printMovement() {
        System.out.println(this.toString() + " went forward " + getDistanceTraveled() + "Km");
    }

    public void printTrajectory() {
        System.out.println(this.getTrajectory().toString());
    }
}
