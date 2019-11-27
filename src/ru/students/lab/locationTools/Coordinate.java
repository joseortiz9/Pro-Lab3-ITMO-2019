package ru.students.lab.locationTools;

public class Coordinate {
    private double x;
    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void addX(double x) {
        this.x += x;
    }

    public void addY(double y) {
        this.y += y;
    }

    public void dropX(double x) {
        this.x -= x;
    }

    public void dropY(double y) {
        this.y -= y;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate))
            return false;
        if (obj == this)
            return true;
        Coordinate objCoord = (Coordinate) obj;
        return this.getX() == objCoord.getX() &&
                this.getY() == objCoord.getY();
    }

    @Override
    public String toString() {
        return " [x=" + this.getX() + ", y=" + this.getY() + "]";
    }
}
