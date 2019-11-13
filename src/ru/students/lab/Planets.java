package ru.students.lab;

public enum Planets {
    Earth("Земля", 1000),
    Moon("Луна", 2000);

    private final String planet;
    private final int distanceFromSun;
    Planets(String planet, int distanceFromSun) {
        this.planet = planet;
        this.distanceFromSun = distanceFromSun;
    }

    @Override
    public String toString() {
        return planet;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }
}
