package ru.students.lab.vehicles;

import ru.students.lab.locationTools.Place;

import java.util.ArrayList;

public class Rocket extends AbsVehicle {

    private ArrayList<Place> rooms;
    private Trajectory trajectory;

    public Rocket(TypeVehicles typeVehicles) {
        super(typeVehicles, 0);
        this.rooms = new ArrayList<>();
        this.trajectory = null;
    }

    public Rocket(TypeVehicles typeVehicles, int velocity, Trajectory trajectory) {
        super(typeVehicles, velocity);
        this.rooms = new ArrayList<>();
        this.trajectory = trajectory;
    }

    public Rocket(TypeVehicles typeVehicles, int velocity, Trajectory trajectory, ArrayList<Place> rooms) {
        super(typeVehicles, velocity);
        this.trajectory = trajectory;
        this.rooms = rooms;
    }

    public void addRoom(Place room) {
        rooms.add(room);
    }

    //If the velocity is enought to arrive in less than an hour
    @Override
    public boolean isVelocityBig() {
        return this.getVelocity().getValue() > getTrajectory().getTotalDistance() / 60;
    }

    @Override
    public MovingState calcStateVelocity() {
        if (this.getVelocity().getValue() == 0)
            return MovingState.STAGNATION;
        return (isVelocityBig()) ? MovingState.FAST : MovingState.SLOW ;
    }

    public void moveForward(int hours) {
        this.getTrajectory().moveNearDestiny(hours, this.getVelocity());
    }

    public boolean overMiddleOfPath() {
        return this.getTrajectory().getDistanceTraveled() > this.getTrajectory().getTotalDistance() / 2;
    }

    public void starts() {
        System.out.println(this.toString() + " rushes with a velocity of " + this.getVelocity().toString());
    }

    public void printLocation() {
        if (overMiddleOfPath())
            System.out.println(this.toString() + " is getting near to Destiny!");
        else
            System.out.println(this.toString() + " hasn't advance even a finger!");
    }

    public void printMovement() {
        System.out.println(this.toString() + " went forward " + this.getTrajectory().getDistanceTraveled() + "Km");
    }

    public void printTrajectory() {
        System.out.println(this.getTrajectory().toString());
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    @Override
    public int hashCode() {
        int result = 35;
        result += (this.getTypeVehicles().hashCode()/50) >> 2;
        result += this.getTrajectory().hashCode();
        result >>= 5;
        result += this.getVelocity().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rocket))
            return false;
        if (obj == this)
            return true;
        Rocket objRocket = (Rocket) obj;
        return this.getVelocity().getValue() == objRocket.getVelocity().getValue() &&
                this.getTrajectory().getDistanceTraveled() == objRocket.getTrajectory().getDistanceTraveled() &&
                this.getTypeVehicles().toString().equals(objRocket.getTypeVehicles().toString());
    }

    @Override
    public String toString() {
        return super.getTypeVehicles().toString();
    }
}


