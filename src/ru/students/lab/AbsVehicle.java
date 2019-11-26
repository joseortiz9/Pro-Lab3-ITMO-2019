package ru.students.lab;

public abstract class AbsVehicle {

    private TypeVehicles typeVehicles;
    private Velocity velocity;
    private int distanceTraveled;
    private int timElapsed;

    public AbsVehicle(TypeVehicles typeVehicles) {
        this.typeVehicles = typeVehicles;
        this.velocity = new Velocity();
        this.distanceTraveled = 0;
        this.timElapsed = 0;
    }

    public AbsVehicle(TypeVehicles typeVehicles, int velocity) {
        this.typeVehicles = typeVehicles;
        this.velocity = new Velocity(velocity);
        this.distanceTraveled = 0;
        this.timElapsed = 0;
    }

    public void moveForward() {
        this.distanceTraveled += this.getTimElapsed() * this.getVelocity().getValue();
    }

    public void addTimElapsed(double hours) {
        this.timElapsed += hours * 3600;
        this.moveForward();
        System.out.println("Passed " + hours + " hours inside " + this.getTypeVehicles().toString());
    }

    public TypeVehicles getTypeVehicles() {
        return this.typeVehicles;
    }

    public int getTimElapsed() {
        return this.timElapsed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public Velocity getVelocity() {
        return this.velocity;
    }
}
