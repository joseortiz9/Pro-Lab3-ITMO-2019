package ru.students.lab;

import java.util.ArrayList;

public class Rocket extends AbsVehicle implements InterUtilities{

    private ArrayList<Place> rooms;
    private Trajectory trajectory;

    public Rocket(TypeVehicles typeVehicles) {
        super(typeVehicles);
        this.rooms = new ArrayList<>();
        this.trajectory = null;
    }

    public Rocket(TypeVehicles typeVehicles, int velocity) {
        super(typeVehicles, velocity);
        this.rooms = new ArrayList<>();
        this.trajectory = null;
    }

    public Rocket(TypeVehicles typeVehicles, int velocity, Trajectory trajectory) {
        super(typeVehicles, velocity);
        this.trajectory = trajectory;
        this.rooms = new ArrayList<>();
    }

    public Rocket(TypeVehicles typeVehicles, int velocity, Trajectory trajectory, ArrayList<Place> rooms) {
        super(typeVehicles, velocity);
        this.trajectory = trajectory;
        this.rooms = rooms;
    }

    public void addRoom(Place room) {
        rooms.add(room);
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public void starts() {
        System.out.println(this.toString() + " rushes with a velocity of " + this.getVelocity().toString());
    }

    //If the velocity is enought to arrive in less than an hour
    public boolean isVelocityBig() {
        return this.getVelocity().getValue() > getTrajectory().calcDistance() / 60;
    }

    public boolean overMiddleOfPath() {
        return this.getDistanceTraveled() > this.getTrajectory().calcDistance() / 2;
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

    @Override
    public int hashCode() {
        return this.getTypeVehicles().toString().hashCode() + this.getVelocity().getValue() + this.getDistanceTraveled();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Rocket))
            return false;
        if (obj == this)
            return true;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return super.getTypeVehicles().toString();
    }
}


