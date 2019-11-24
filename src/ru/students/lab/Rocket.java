package ru.students.lab;

import java.util.ArrayList;

public class Rocket extends AbsVehicle {

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

    public void addRoom(Place room) {
        rooms.add(room);
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public void starts() {
        System.out.println(this.toString() + " rushes with a velocity of " + this.getVelocityStr());
    }

    //If the velocity is enought to arrive in less than an hour
    public boolean isVelocityBig() {
        return this.getVelocity() > getTrajectory().calcDistance() / 60;
    }

    public boolean overMiddleOfPath() {
        return this.getDistanceTraveled() > this.getTrajectory().calcDistance() / 2;
    }

    public String isNearDestiny() {
        if (this.overMiddleOfPath())
            return this.toString() + " is getting near to Destiny!";
        else
            return this.toString() + " haven't advance even a finger!";
    }

    public void printMovement() {
        System.out.println(this.toString() + " went forward " + getDistanceTraveled() + "Km");
    }

    public void printTrajectory() {
        System.out.println(this.getTrajectory().toString());
    }

    @Override
    public int hashCode() {
        return this.getTypeVehicle().toString().hashCode() + this.getVelocity() + this.getDistanceTraveled();
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
        return super.getTypeVehicle().toString();
    }
}


