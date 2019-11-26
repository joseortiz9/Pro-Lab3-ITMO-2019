package ru.students.lab;

public enum TypeThings {
    Food("Еда"),
    Computer("Компьютер");

    private final String name;
    TypeThings(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
