package ru.students.lab;

import java.util.ArrayList;

public abstract class AbsVehicle {

    private TypeVehicle typeVehicle;
    private int velocity;
    private int distanceTraveled;
    private int timElapsed;

    public AbsVehicle(TypeVehicle typeVehicle) {
        this.typeVehicle = typeVehicle;
        this.velocity = 0;
        this.distanceTraveled = 0;
        this.timElapsed = 0;
    }

    public AbsVehicle(TypeVehicle typeVehicle, int velocity) {
        this.typeVehicle = typeVehicle;
        this.velocity = velocity;
        this.distanceTraveled = 0;
        this.timElapsed = 0;
    }

    public void moveForward() {
        this.distanceTraveled += this.getTimElapsed() * this.getVelocity();
    }

    public void addTimElapsed(double hours) {
        this.timElapsed += hours * 3600;
        this.moveForward();
        System.out.println("Passed " + hours + " hours");
    }

    public TypeVehicle getTypeVehicle() {
        return this.typeVehicle;
    }

    public int getTimElapsed() {
        return this.timElapsed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public String getVelocityStr() {
        return this.velocity + "km/s";
    }
}
