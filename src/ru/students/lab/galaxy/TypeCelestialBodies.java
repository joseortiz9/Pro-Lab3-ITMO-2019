package ru.students.lab.galaxy;

public enum TypeCelestialBodies {
    PLANET("Планета"),
    STAR("Звезда"),
    SATELLITE("Спутник"),
    COMET("Комета"),
    ASTEROID("Астероид"),
    METEOROID("Метеороид");

    private final String name;
    TypeCelestialBodies(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
