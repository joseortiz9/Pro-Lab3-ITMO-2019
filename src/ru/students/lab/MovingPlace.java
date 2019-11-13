package ru.students.lab;

public class MovingPlace extends AbsPlace {
    private double velocity;
    public MovingPlace(String name, Coordinate coordinates, double velocity) {
        super(name, coordinates);
        this.velocity = velocity;
    }
}
