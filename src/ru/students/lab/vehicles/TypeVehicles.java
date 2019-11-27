package ru.students.lab.vehicles;

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