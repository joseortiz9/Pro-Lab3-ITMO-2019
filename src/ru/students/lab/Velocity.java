package ru.students.lab;

public class Velocity {
    private int velocity;

    public Velocity() {
        this.velocity = 0;
    }
    public Velocity(int velocity) {
        this.velocity = velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getValue() {
        return velocity;
    }

    @Override
    public int hashCode() {
        return this.getValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Trajectory))
            return false;
        if (obj == this)
            return true;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return this.getValue() + "км/с";
    }
}