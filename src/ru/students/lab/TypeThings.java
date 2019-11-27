package ru.students.lab;

public enum TypeThings {
    FOOD("Еда"),
    WINDOW("Окно"),
    COMPUTER("Компьютер"),
    PANEL("Пульт управления");

    private final String name;
    TypeThings(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
