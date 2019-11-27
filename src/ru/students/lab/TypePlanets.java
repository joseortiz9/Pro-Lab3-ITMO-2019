package ru.students.lab;

public enum TypePlanets {
    EARTH("Земля"),
    MOON("Луна");

    private final String planet;
    TypePlanets(String planet) {
        this.planet = planet;
    }

    @Override
    public String toString() {
        return this.planet;
    }
}
