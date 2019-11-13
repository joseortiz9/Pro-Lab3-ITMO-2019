package ru.students.lab;

import java.util.ArrayList;

public class Vehicle extends AbsVehicle implements InterStandardFunctions {

    public Vehicle(TypeVehicle typeVehicle) {
        super(typeVehicle);
    }

    public Vehicle(TypeVehicle typeVehicle, int velocity) {
        super(typeVehicle, velocity);
    }

    public Vehicle(TypeVehicle typeVehicle, int velocity, ArrayList<Place> rooms) {
        super(typeVehicle, velocity, rooms);
    }

    @Override
    public String toString() {
        return super.getTypeVehicle().toString();
    }

    public void starts() {
        System.out.println(this.toString() + " rushes with a velocity of " + this.getVelocity());
    }
}
