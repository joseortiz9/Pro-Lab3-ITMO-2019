package ru.students.lab.timeTools;

public enum PartsOfDay {
    MORNING("Утром"),
    AFTERNOON("Днём"),
    EVENING("Вечером"),
    NIGHT("Ночью");

    private final String name;
    PartsOfDay(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
