package ru.students.lab;

public enum TypeVehicle {
    Rocket("Ракета"),
    Car("Машина");

    private final String name;
    TypeVehicle(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}