package ru.students.lab;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
        return "[x=" + this.getX() + ", y=" + this.getY() + "]";
    }
}
