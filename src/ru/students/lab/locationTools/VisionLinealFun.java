package ru.students.lab.locationTools;

/**
 *  y=mx + b
 *  m: slope
 */

public class VisionLinealFun {
    private Coordinate c1;
    private Coordinate c2;
    private double slope;
    private double b;

    public VisionLinealFun(Coordinate c1, Coordinate c2) {
        this.c1 = c1;
        this.c2 = c2;
        this.slope = this.calculateSlope();
        this.b = this.calculateB();
    }

    public double calDeltaY() {
        return (this.getC2().getY() - this.getC1().getY());
    }

    public double calcDeltaX() {
        return (this.getC2().getX() - this.getC1().getX());
    }

    public double calculateSlope() {
        if (calcDeltaX() == 0)
            return this.getC1().getX();
        else if (calDeltaY() == 0)
            return this.getC1().getY();
        return calDeltaY() / calcDeltaX();
    }

    public double calculateB() {
        if (calcDeltaX() == 0 || calDeltaY() == 0)
            return 0;
        return this.getC1().getY() - (this.getSlope() * this.getC1().getX());
    }

    public double getYFromFunction(double x) {
        return (this.getSlope() * this.getC1().getX()) + this.getB();
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
        if (!(obj instanceof VisionLinealFun))
            return false;
        if (obj == this)
            return true;
        VisionLinealFun objVision = (VisionLinealFun) obj;
        return this.getSlope() == objVision.getSlope()  &&
                this.getB() == objVision.getB();
    }

    @Override
    public String toString() {
        return "[f(x) = " + this.getSlope() + "x " + this.getB() + "]";
    }
}
