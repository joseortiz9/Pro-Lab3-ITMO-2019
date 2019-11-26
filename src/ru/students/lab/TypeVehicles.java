package ru.students.lab;

public enum TypeVehicles {
    Rocket("Ракета"),
    Car("Машина");

    private final String name;
    TypeVehicles(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}