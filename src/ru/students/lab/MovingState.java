package ru.students.lab;

public enum MovingState {
    FAST("Fast"),
    SLOW("Slow"),
    STAGNATION("without");

    private final String name;
    MovingState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
            return name;
        }
}
