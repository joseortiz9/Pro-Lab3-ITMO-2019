package ru.students.lab;

import java.util.ArrayList;

public abstract class AbsVehicle {

    private TypeVehicle typeVehicle;
    private ArrayList<Place> rooms;
    private int velocity;

    public AbsVehicle(TypeVehicle typeVehicle) {
        this.typeVehicle = typeVehicle;
        this.rooms = new ArrayList<>();
        this.velocity = 0;
    }

    public AbsVehicle(TypeVehicle typeVehicle, int velocity) {
        this.typeVehicle = typeVehicle;
        this.velocity = velocity;
        this.rooms = new ArrayList<>();
    }

    public AbsVehicle(TypeVehicle typeVehicle, int velocity, ArrayList<Place> rooms) {
        this.typeVehicle = typeVehicle;
        this.velocity = velocity;
        this.rooms = rooms;
    }

    public TypeVehicle getTypeVehicle() {
        return typeVehicle;
    }

    public String getVelocity() {
        return velocity + "km/s";
    }

    public void addRoom(Place room) {
        rooms.add(room);
    }
}
