package ru.students.lab;

public enum Organs {
    Stomach("Stomach"),
    Eyes("Eyes");

    private final String name;
    Organs(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
