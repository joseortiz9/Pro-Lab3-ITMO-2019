package ru.students.lab;

public class Coordinate {

    private String name;
    private double x;
    private double y;

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
        name = getCoordString(this.x) + "/" + getCoordString(this.y);
    }

    public Coordinate(double x, double y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String getCoordString(double coord) {
        return String.valueOf(coord);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public double[] getCoordinate(){
        return new double[]{this.x, this.y};
    }
}
