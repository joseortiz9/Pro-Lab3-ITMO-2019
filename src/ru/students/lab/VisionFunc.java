package ru.students.lab;

/**
 *  y=mx + b
 *  m: slope
 */

public class VisionFunc {
    private Coordinate c1;
    private Coordinate c2;
    private double slope;
    private double b;

    public VisionFunc(Coordinate c1, Coordinate c2) {
        this.c1 = c1;
        this.c2 = c2;
        this.slope = this.calculateSlope();
        this.b = this.calculateB();
    }

    public double calculateSlope() {
        return (this.getC2().getY() - this.getC1().getY()) /
                (this.getC2().getX() - this.getC1().getX());
    }

    public double calculateB(){
        return this.getC1().getY() - (this.getSlope() * this.getC1().getX());
    }

    public double getYFromFunction(double x) {
        return (this.getSlope() * this.getC1().getX()) + this.getB();
    }

    public boolean positiveFunc() {
        return this.getSlope() >= 0;
    }

    public Coordinate getC1() {
        return c1;
    }

    public Coordinate getC2() {
        return c2;
    }

    public double getSlope() {
        return this.slope;
    }

    public double getB() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VisionFunc))
            return false;
        if (obj == this)
            return true;
        VisionFunc objVision = (VisionFunc) obj;
        return Math.abs(this.getSlope()) == Math.abs(objVision.getSlope())  &&
                this.getB() == objVision.getB();
    }

    @Override
    public String toString() {
        return "[f(x) = " + this.getSlope() + "x +" + this.getB() + "]";
    }
}