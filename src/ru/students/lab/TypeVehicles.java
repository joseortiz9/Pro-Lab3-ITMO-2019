package ru.students.lab;

public enum TypeVehicles {
    ROCKET("Ракета"),
    CAR("Машина");

    private final String name;
    TypeVehicles(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}