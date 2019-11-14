package ru.students.lab;

public enum Planets {
    Earth("Земля", 149598000),
    Moon("Луна", 150000000);

    private final String planet;
    private final double distanceFromSun; // xxx thousands of Km
    Planets(String planet, double distanceFromSun) {
        this.planet = planet;
        this.distanceFromSun = distanceFromSun;
    }

    @Override
    public String toString() {
        return planet;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public String getDistanceFromSunStr() {
        return distanceFromSun + "thousand Km";
    }
}
