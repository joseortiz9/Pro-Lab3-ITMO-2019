package ru.students.lab.sensesTools;

public enum TypeSizePerceptions {
    SMALL("маленький"),
    MEDIUM("средний"),
    BIG("большой");

    private final String name;
    TypeSizePerceptions(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
