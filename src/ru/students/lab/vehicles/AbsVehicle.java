package ru.students.lab.vehicles;

import java.rmi.MarshalledObject;

public abstract class AbsVehicle {

    private TypeVehicles typeVehicles;
    private Velocity velocity;
    private MovingState movingState;

    public AbsVehicle(TypeVehicles typeVehicles) {
        this.typeVehicles = typeVehicles;
        this.velocity = new Velocity();
        this.movingState = MovingState.STAGNATION;
    }

    public AbsVehicle(TypeVehicles typeVehicles, int velocity) {
        this.typeVehicles = typeVehicles;
        this.velocity = new Velocity(velocity);
        this.movingState = (velocity > 0) ? MovingState.SLOW : MovingState.STAGNATION;
    }

    public abstract MovingState calcStateVelocity();

    public abstract boolean isVelocityBig();

    public MovingState getMovingState() {
        return movingState;
    }

    public TypeVehicles getTypeVehicles() {
        return this.typeVehicles;
    }

    public Velocity getVelocity() {
        return this.velocity;
    }
}
