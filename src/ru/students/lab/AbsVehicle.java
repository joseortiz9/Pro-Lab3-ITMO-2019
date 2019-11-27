package ru.students.lab;

public abstract class AbsVehicle {

    private TypeVehicles typeVehicles;
    private Velocity velocity;

    public AbsVehicle(TypeVehicles typeVehicles) {
        this.typeVehicles = typeVehicles;
        this.velocity = new Velocity();

    }

    public AbsVehicle(TypeVehicles typeVehicles, int velocity) {
        this.typeVehicles = typeVehicles;
        this.velocity = new Velocity(velocity);
    }

    public TypeVehicles getTypeVehicles() {
        return this.typeVehicles;
    }

    public Velocity getVelocity() {
        return this.velocity;
    }
}
