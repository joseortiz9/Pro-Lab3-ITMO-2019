package ru.students.lab.vehicles;

public enum MovingState {
    FAST("Fast"),
    SLOW("Slow"),
    STAGNATION("No");

    private final String name;
    MovingState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
            return name;
        }
}
